package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniVisitPage.java
 * @time 14:54/2018-12-19
 * @desc
 */
@Data
public class WechatMiniVisitPage implements Serializable {

    /**
     * 页面路径
     */
    @SerializedName(value = "pagePath", alternate = "page_path")
    private String pagePath;
    /**
     * 访问次数
     */
    @SerializedName(value = "pageVisitPv", alternate = "page_visit_pv")
    private Long pageVisitPv;
    /**
     * 访问人数
     */
    @SerializedName(value = "pageVisitUv", alternate = "page_visit_uv")
    private Long pageVisitUv;
    /**
     * 次均停留时长
     */
    @SerializedName(value = "pageStayTimePv", alternate = "page_staytime_pv")
    private Float pageStayTimePv;
    /**
     * 进入页次数
     */
    @SerializedName(value = "entryPagePv", alternate = "entrypage_pv")
    private Long entryPagePv;
    /**
     * 退出页次数
     */
    @SerializedName(value = "exitPagePv", alternate = "exitpage_pv")
    private Long exitPagePv;
    /**
     * 转发次数
     */
    @SerializedName(value = "pageSharePv", alternate = "page_share_pv")
    private Long pageSharePv;
    /**
     * 转发人数
     */
    @SerializedName(value = "pageShareUv", alternate = "page_share_uv")
    private Long pageShareUv;
}
