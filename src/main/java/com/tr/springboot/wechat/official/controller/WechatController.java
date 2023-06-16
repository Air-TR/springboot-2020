package com.tr.springboot.wechat.official.controller;

import com.alibaba.fastjson.JSONObject;
import com.tr.springboot.kit.StringKit;
import com.tr.springboot.kit.WechatKit;
import com.tr.springboot.wechat.official.constant.RedisKey;
import com.tr.springboot.wechat.official.constant.Wechat;
import com.tr.springboot.wechat.official.controller.dto.WechatCallbackDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: TR
 * @Date: 2023/6/16
 */
@Api(tags = "微信")
@RestController
public class WechatController {

    @Resource
    private WxMpQrcodeService wxMpQrcodeService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 该方法主要两个用途：
     *  1.在微信公众平台 -->《基本配置》-《服务器配置》中配置 “服务器地址(URL)” 时会被微信调用，验证回调接口的可用性
     *  2.在调用 getQrCode() 获取到二维码后，用户扫码时微信会调该接口，这里调用目的不是为了验证，而是为了传输用户信息，如 openid 就是在此次回调中获取
     *  两次调用的区别：
     *   1.验证调用时 echostr 传参不为空
     *   2.扫码触发回调时 echostr 传参为空
     */
    @ApiOperation("回调接口")
    @PostMapping("/wechat/callback")
    public String test(@RequestParam(value = "signature", required = false) String signature,
                       @RequestParam(value = "timestamp", required = false) String timestamp,
                       @RequestParam(value = "nonce", required = false) String nonce,
                       @RequestParam(value = "echostr", required = false) String echostr,
                       @RequestBody(required = false) WechatCallbackDto wechatCallbackDto) {
        if (StringKit.isNotBlank(echostr) && checkSignature(signature, timestamp, nonce)) {
            // 用于微信回调校验，必须返回 echostr
            return echostr;
        }
        if (wechatCallbackDto != null) {
            String openid = wechatCallbackDto.getFromUserName();
            String qrCodeId = wechatCallbackDto.getEventKey();
            stringRedisTemplate.opsForValue().set(RedisKey.WECHAT_QR_CODE_ID + qrCodeId, openid, Wechat.QR_CODE_TIMEOUT, TimeUnit.SECONDS);
        }
        return "success"; // 必须返回 success，否则可能认为此次回调失败，在用户微信公众号上显示 “该公众号提供的服务出现故障”
    }

    /**
     * 校验请求是否来自微信服务器
     */
    private boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{Wechat.TOKEN, timestamp, nonce};
        // 将 token、timestamp、nonce 三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        String sha1 = DigestUtils.sha1Hex(sb.toString());
        return sha1.equals(signature);
    }

    @ApiOperation("获取二维码")
    @GetMapping( "/wechat/getQrCode")
    public JSONObject getQrCode() throws WxErrorException {
        String qrCodeId = UUID.randomUUID().toString();
        WxMpQrCodeTicket ticket = wxMpQrcodeService.qrCodeCreateTmpTicket(qrCodeId, Wechat.QR_CODE_TIMEOUT);
        String url = wxMpQrcodeService.qrCodePictureUrl(ticket.getTicket());
        JSONObject data = new JSONObject();
        data.put("url", url);
        data.put("qrCodeId", qrCodeId);
        return data;
    }

    @ApiOperation("根据 code 获取 access_token 和 openid")
    @GetMapping( "/wechat/getAccessTokenAndOpenid/{code}")
    public String getAccessTokenAndOpenid(@PathVariable String code) {
        return WechatKit.getAccessTokenAndOpenid(Wechat.APP_ID, Wechat.APP_SECRET, code);
    }

}
