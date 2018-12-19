package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniTemplateListResult.java
 * @time 13:48/2018-12-19
 * @desc
 */
@Data
public class WechatMiniTemplateListResult implements Serializable {

    private List<TemplateInfo> list;

    public static WechatMiniTemplateListResult fromJson(String json){
        return new GsonBuilder().create().fromJson(json, WechatMiniTemplateListResult.class);
    }

    @Data
    public static class TemplateInfo{

        @SerializedName("template_id")
        private String templateId;
        private String title;
        private String content;
        private String example;
    }
}
