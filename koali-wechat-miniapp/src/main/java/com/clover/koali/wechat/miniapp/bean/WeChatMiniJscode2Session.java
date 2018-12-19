package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WeChatJscode2Session.java
 * @time 14:40/2018-12-11
 * @desc
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WeChatMiniJscode2Session implements Serializable {

    @SerializedName("openid")
    private String openid;
    @SerializedName("session_key")
    private String sessionKey;
    @SerializedName("unionid")
    private String unionid;

    public static WeChatMiniJscode2Session fromJson(String json){
        return new GsonBuilder().create().fromJson(json, WeChatMiniJscode2Session.class);
    }

    @Override
    public String toString() {
        return "WeChatJscode2Session{" +
                "openid='" + openid + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
