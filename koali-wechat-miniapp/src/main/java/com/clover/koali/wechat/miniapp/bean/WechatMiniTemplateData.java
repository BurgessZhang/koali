package com.clover.koali.wechat.miniapp.bean;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniTemplateData.java
 * @time 14:29/2018-12-19
 * @desc
 */
@Data
@NoArgsConstructor
public class WechatMiniTemplateData implements Serializable {

    private String name;
    private String value;
    private String color;

    public WechatMiniTemplateData(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public WechatMiniTemplateData(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }


}
