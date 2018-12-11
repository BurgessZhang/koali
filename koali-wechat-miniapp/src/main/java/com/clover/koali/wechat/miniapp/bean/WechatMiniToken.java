package com.clover.koali.wechat.miniapp.bean;


import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniToken.java
 * @time 13:34/2018-12-11
 * @desc token bean信息
 */
public class WechatMiniToken implements Serializable {

    //小程序AppId
    private String appId;
    //小程序appSecret
    private String appSecret;
    //小程序的凭证
    private String accessToken;
    //小程序有效时间
    private Long expiresIn;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

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
