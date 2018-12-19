package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniCategory.java
 * @time 14:45/2018-12-19
 * @desc
 */
@Data
@Builder
public class WechatMiniCategory implements Serializable {

    /**
     * 一级类目名称
     */
    @SerializedName("first_class")
    private String firstClass;
    /**
     * 二级类目名称
     */
    @SerializedName("second_class")
    private String secondClass;
    /**
     * 三级类目名称
     */
    @SerializedName("third_class")
    private String thirdClass;
    /**
     * 一级类目的ID编号
     */
    @SerializedName("first_id")
    private Long firstId;
    /**
     * 二级类目的ID编号
     */
    @SerializedName("second_id")
    private Long secondId;
    /**
     * 三级类目的ID编号
     */
    @SerializedName("third_id")
    private Long thirdId;

    /**
     * 小程序的页面，可通过“获取小程序的第三方提交代码的页面配置”接口获得
     */
    private String address;
    /**
     * 小程序的标签，多个标签用空格分隔，标签不能多于10个，标签长度不超过20
     */
    private String tag;
    /**
     * 小程序页面的标题,标题长度不超过32
     */
    private String title;
}
