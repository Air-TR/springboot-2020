package com.tr.springboot.wechat.official.controller.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: TR
 * @Date: 2023/6/16
 */
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatCallbackDto {

    @XmlElement(name = "ToUserName")
    private String toUserName;

    /** fromUserName 为关注人的 openid */
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    @XmlElement(name = "CreateTime")
    private String createTime;

    @XmlElement(name = "MsgType")
    private String msgType;

    @XmlElement(name = "Event")
    private String event;

    /** eventKey 为创建二维码的 qrCodeId */
    @XmlElement(name = "EventKey")
    private String eventKey;

    @XmlElement(name = "Content")
    private String content;
}
