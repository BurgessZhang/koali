package com.clover.koali.wechat.miniapp.bean;


import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WeChatJscode2Session.java
 * @time 14:40/2018-12-11
 * @desc
 */
public class WeChatJscode2Session implements Serializable {

    private String openid;
    private String sessionKey;
    private String unionid;


    @Override
    public String toString() {
        return "WeChatJscode2Session{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
