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
 * @file WechatMiniTemplateLibraryGetResult.java
 * @time 13:44/2018-12-19
 * @desc
 */
@Data
public class WechatMiniTemplateLibraryGetResult implements Serializable {

    private String id;
    private String title;
    @SerializedName("keyword_list")
    private List<KeywordInfo> keywordList;

    @Data
    public static class KeywordInfo{

        @SerializedName("keyword_id")
        private int keywordId;
        private String name;
        private String example;
    }

    public static WechatMiniTemplateLibraryGetResult fromJson(String json){
        return new GsonBuilder().create().fromJson(json, WechatMiniTemplateLibraryGetResult.class);
    }
}
