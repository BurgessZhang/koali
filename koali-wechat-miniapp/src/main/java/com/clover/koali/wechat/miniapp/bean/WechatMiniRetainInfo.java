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
 * @file WechatMiniRetainInfo.java
 * @time 14:53/2018-12-19
 * @desc
 */
@Data
public class WechatMiniRetainInfo implements Serializable {

    /**
     * 日留存：日期，yyyyMMdd 格式，如 20170313
     * 周留存：时间，如"20170306-20170312"
     * 月留存：时间，如"201702"
     */
    @SerializedName(value = "refDate", alternate = "ref_date")
    private String refDate;
    /**
     * 新增用户留存
     * - key:
     *  - 日留存：标识，0开始，0表示当天，1表示1天后，依此类推，key取值分别是：0,1,2,3,4,5,6,7,14,30
     *  - 周留存：标识，0开始，0表示当周，1表示1周后，依此类推，key 取值分别是：0,1,2,3,4
     *  - 月留存：标识，0开始，0表示当月，1表示1月后，key取值分别是：0,1
     * - value: key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
     */
    private Map<Integer, Integer> visitUvNew;
    /**
     * 活跃用户留存
     */
    private Map<Integer, Integer> visitUv;

    public static WechatMiniRetainInfo fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniRetainInfo.class);
    }
}