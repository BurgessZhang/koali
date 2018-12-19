package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniTemplateAddResult.java
 * @time 13:45/2018-12-19
 * @desc
 */
@Data
public class WechatMiniTemplateAddResult implements Serializable {

    @SerializedName("template_id")
    private String templateId;

    public static WechatMiniTemplateAddResult fromJson(String json){
        return new GsonBuilder().create().fromJson(json, WechatMiniTemplateAddResult.class);
    }
}
