package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniMediaUploadResult.java
 * @time 14:34/2018-12-19
 * @desc
 */
@Data
public class WechatMiniMediaUploadResult implements Serializable {

    private String url;
    private String type;
    private String mediaId;
    private String thumbMediaId;
    private long createdAt;

    public static WechatMiniMediaUploadResult fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniMediaUploadResult.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
