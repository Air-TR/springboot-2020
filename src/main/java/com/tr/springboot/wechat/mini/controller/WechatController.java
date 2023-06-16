package com.tr.springboot.wechat.mini.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import com.tr.springboot.kit.WechatKit;
import com.tr.springboot.wechat.official.constant.Wechat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: TR
 * @Date: 2023/6/16
 */
@Api(tags = "微信")
@RestController
public class WechatController {

    @Resource
    private WxMaService wxMaService;

    @ApiOperation("根据 code 获取 session_key 和 openid")
    @GetMapping( "/wechat/getSessionKeyAndOpenid/{code}")
    public String getSessionKeyAndOpenid(@PathVariable String code) {
        return WechatKit.getSessionKeyAndOpenid(Wechat.APP_ID, Wechat.APP_SECRET, code);
    }

    @SneakyThrows
    @PostMapping(value = "/wechat/getUserinfo")
    @ApiOperation("微信通过code获取小程序端的用户信息")
    public ResponseEntity test1(@RequestParam String code) {
        WxMaUserService userService = wxMaService.getUserService();
        return ResponseEntity.ok(userService.getSessionInfo(code));
    }

}
