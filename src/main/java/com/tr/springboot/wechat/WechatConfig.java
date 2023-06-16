package com.tr.springboot.wechat;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.tr.springboot.wechat.official.constant.Wechat;
import me.chanjar.weixin.mp.api.WxMpQrcodeService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: TR
 * @Date: 2023/6/16
 */
@Configuration
public class WechatConfig {

    @Bean
    public WxMpService wxMpService() {
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(Wechat.APP_ID);
        config.setSecret(Wechat.APP_SECRET);
        WxMpServiceImpl service = new WxMpServiceImpl();
        service.setWxMpConfigStorage(config);
        return service;
    }

    @Bean
    protected WxMpQrcodeService wxMpQrcodeService(WxMpService wxMpService) {
        return wxMpService.getQrcodeService();
    }

    /** --------------- 以上是公众号配置，以下是小程序配置 --------------- */

    @Bean
    public WxMaService wxMaService(WxMaConfig wxMaConfig) {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }

    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(Wechat.APP_ID);
        config.setSecret(Wechat.APP_SECRET);
        return config;
    }

}