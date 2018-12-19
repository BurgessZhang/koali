package com.clover.koali.wechat.miniapp.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniToken.java
 * @time 13:34/2018-12-11
 * @desc token bean信息
 */
@Data
public class WechatMiniToken implements Serializable {

    //小程序AppId
    private String appId;
    //小程序appSecret
    private String appSecret;
    //小程序的凭证
    private String accessToken;
    //小程序有效时间
    private Long expiresIn;

    @Override
    public String toString() {
        return "WechatMiniToken{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                '}';
    }
}
