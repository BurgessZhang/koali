package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniCodeCommitRequest.java
 * @time 14:43/2018-12-19
 * @desc
 */
@Data
@Builder
public class WechatMiniCodeCommitRequest implements Serializable {

    /**
     * 代码库中的代码模版ID
     */
    private Long templateId;
    /**
     * 第三方自定义的配置
     */
    private WechatMiniCodeExtConfig extConfig;
    /**
     * 代码版本号，开发者可自定义
     */
    private String userVersion;
    /**
     * 代码描述，开发者可自定义
     */
    private String userDesc;

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
