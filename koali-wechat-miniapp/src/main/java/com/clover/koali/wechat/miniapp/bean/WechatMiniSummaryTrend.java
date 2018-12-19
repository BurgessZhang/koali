package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniSummaryTrend.java
 * @time 14:51/2018-12-19
 * @desc
 */
@Data
public class WechatMiniSummaryTrend implements Serializable {

    /**
     * 日期，yyyyMMdd 格式，如 20170313
     */
    @SerializedName(value = "refDate", alternate = "ref_date")
    private String refDate;
    /**
     * 累计用户数
     */
    @SerializedName(value = "visitTotal", alternate = "visit_total")
    private Long visitTotal;
    /**
     * 转发次数
     */
    @SerializedName(value = "sharePv", alternate = "share_pv")
    private Long sharePv;
    /**
     * 转发人数
     */
    @SerializedName(value = "shareUv", alternate = "share_uv")
    private Long shareUv;
}
