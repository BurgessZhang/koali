package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniUserPortrait.java
 * @time 14:54/2018-12-19
 * @desc
 */
@Data
public class WechatMiniUserPortrait implements Serializable {

    /**
     * 时间范围,如： "20170611-20170617"
     */
    private String refDate;
    /**
     * 新用户
     */
    private Item visitUvNew;
    /**
     * 活跃用户
     */
    private Item visitUv;

    public static WechatMiniUserPortrait fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniUserPortrait.class);
    }

    @Data
    public static class Item {
        /**
         * key: 省份，如北京、广东等
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> province;
        /**
         * key: 城市，如北京、广州等
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> city;
        /**
         * key: 性别，包括男、女、未知
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> genders;
        /**
         * key: 终端类型，包括iPhone, android,其他
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> platforms;
        /**
         * key: 机型，如苹果iPhone6, OPPO R9等
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> devices;
        /**
         * key: 年龄，包括17岁以下、18-24岁等区间
         * value: 活跃用户数或新用户数
         */
        private Map<String, Long> ages;
    }
}
