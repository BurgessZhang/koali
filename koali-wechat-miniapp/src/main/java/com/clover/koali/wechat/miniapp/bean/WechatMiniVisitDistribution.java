package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniVisitDistribution.java
 * @time 14:52/2018-12-19
 * @desc
 */
@Data
public class WechatMiniVisitDistribution implements Serializable {

    /**
     * 日期，yyyyMMdd 格式，如 20170313
     */
    @SerializedName(value = "refDate", alternate = "ref_date")
    private String refDate;
    /**
     * key: 分布类型
     * - access_source_session_cnt 访问来源分布
     * - access_staytime_info 访问时长分布
     * - access_depth_info 访问深度的分布
     * value: 场景 ID 下的值
     * - key: 场景 ID
     * - value: 场景下的值
     */
    private Map<String, Map<Integer, Integer>> list;

    public static WechatMiniVisitDistribution fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniVisitDistribution.class);
    }
}
