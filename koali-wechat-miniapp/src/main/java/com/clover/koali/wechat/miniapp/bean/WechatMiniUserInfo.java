package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatUserInfo.java
 * @time 14:45/2018-12-11
 * @desc 微信用户信息
 */
@Data
public class WechatMiniUserInfo implements Serializable {

    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private Watermark watermark;

    public static WechatMiniUserInfo fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniUserInfo.class);
    }
    @Override
    public String toString() {
        return "WechatUserInfo{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", unionId='" + unionId + '\'' +
                ", watermark=" + watermark.toString() +
                '}';
    }

    @Data
    public static class Watermark implements Serializable{
        private String timestamp;
        private String appid;

        @Override
        public String toString() {
            return "Watermark{" +
                    "timestamp='" + timestamp + '\'' +
                    ", appid='" + appid + '\'' +
                    '}';
        }
    }
}
