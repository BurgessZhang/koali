package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniAccessToken.java
 * @time 14:12/2018-12-19
 * @desc
 */
@Data
public class WechatMiniAccessToken implements Serializable {

    private String accessToken;

    private int expiresIn = -1;

    public static WechatMiniAccessToken fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniAccessToken.class);
    }
}
