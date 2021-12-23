package com.tr.springboot.util.sendmsg;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jsms.api.SendSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 极光短信
 *
 * @author rtao
 * @date 2021/9/23 10:51
 */
public class JsmsUtils {

    protected static final Logger log = LoggerFactory.getLogger(JsmsUtils.class);

    // 这两个码要先去极光短信注册申请和充值后才会生效
    private static final String appkey = "";
    private static final String masterSecret = "";

    public static void main(String[] args) {
        // 这里要填入你测试用的手机号和验证码
        sendTemplateSMS("手机号","验证码");
    }

    // 这段是按照模板发送短信的代码。模板类似验证码模板，code替换验证码位置
    public static void sendTemplateSMS(String mobile,String code) {
        SMSClient client = new SMSClient(masterSecret, appkey);
        SMSPayload payload = SMSPayload.newBuilder()
                .setMobileNumber(mobile)
                .setTempId(1)
                .addTempPara("code", code)
                .build();
        try {
            SendSMSResult res = client.sendTemplateSMS(payload);
            log.info(res.toString());
        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Message: " + e.getMessage());
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
        }
    }

}
