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
 * @file WechatMiniTemplateLibraryListResult.java
 * @time 13:33/2018-12-19
 * @desc
 */
@Data
public class WechatMiniTemplateLibraryListResult implements Serializable {


    @SerializedName("total_count")
    private int totalCount;
    private List<TemplateItem> list;

    public static WechatMiniTemplateLibraryListResult fromJson(String json){
        return new GsonBuilder().create().fromJson(json,WechatMiniTemplateLibraryListResult.class);
    }

    @Data
    public static class TemplateItem{
        private String id;
        private String title;
    }

}
