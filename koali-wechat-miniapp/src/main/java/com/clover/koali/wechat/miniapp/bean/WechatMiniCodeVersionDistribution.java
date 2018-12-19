package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniCodeVersionDistribution.java
 * @time 14:47/2018-12-19
 * @desc
 */
@Data
public class WechatMiniCodeVersionDistribution implements Serializable {

    /**
     * 当前版本
     */
    private String nowVersion;
    /**
     * 受影响用户占比
     * key: version, 版本号
     * value: percentage, 受影响比例
     */
    private Map<String, Float> uvInfo;

    public static WechatMiniCodeVersionDistribution fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniCodeVersionDistribution.class);
    }
}
