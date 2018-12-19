package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatPhoneNumberInfo.java
 * @time 13:22/2018-12-19
 * @desc 微信用户绑定的手机号信息
 */
@Data
public class WechatMiniPhoneNumberInfo implements Serializable {

    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    private Watermark watermark;

    public static WechatMiniPhoneNumberInfo fromJson(String json){
        return new GsonBuilder().create().fromJson(json,WechatMiniPhoneNumberInfo.class);
    }

    @Data
    public static class Watermark {
        private String timestamp;
        private String appid;
    }

    @Override
    public String toString() {
        return "WechatPhoneNumberInfo{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", purePhoneNumber='" + purePhoneNumber + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", watermark=" + watermark +
                '}';
    }
}
