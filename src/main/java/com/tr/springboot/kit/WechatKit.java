package com.tr.springboot.kit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class WechatKit {

    /**
     * 根据 code 获取 session_key 和 openid（本方法适用于小程序）
     * @param appid
     * @param appsecret
     * @param code
     * @return session_key openid
     */
    public static String getSessionKeyAndOpenid(String appid, String appsecret, String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appsecret
                + "&js_code=" + code + "&grant_type=authorization_code";
        return getResultByUrl(url);
    }

    /**
     * 根据 code 获取 access_token 和 openid（本方法适用于公众号）
     * @param appid
     * @param appsecret
     * @param code
     * @return access_token openid
     */
    public static String getAccessTokenAndOpenid(String appid, String appsecret, String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecret
                + "&code=" + code + "&grant_type=authorization_code";
        return getResultByUrl(url);
    }

    public static String getResultByUrl(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getUrl(String appid, String redirectUrl) throws UnsupportedEncodingException {
        String scope = "snsapi_userinfo";
        String state = "STATE";
        return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + URLEncoder.encode(redirectUrl, "UTF-8") + "&response_type=code&scope=" + scope + "&state=" + state + "#wechat_redirect";
    }
}