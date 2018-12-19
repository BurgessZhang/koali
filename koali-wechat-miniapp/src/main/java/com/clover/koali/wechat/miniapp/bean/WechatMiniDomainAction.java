package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniDomainAction.java
 * @time 13:53/2018-12-19
 * @desc 域名相关操作
 */
@Data
@Builder
public class WechatMiniDomainAction implements Serializable {

    /**
     * add添加, delete删除, set覆盖, get获取。当参数是get时不需要填四个域名字段
     */
    private String action;
    /**
     * request合法域名，当action参数是get时不需要此字段。
     */
    @SerializedName("requestdomain")
    private List<String> requestDomain;
    /**
     * socket合法域名，当action参数是get时不需要此字段。
     */
    @SerializedName("wsrequestdomain")
    private List<String> wsRequestDomain;
    /**
     * uploadFile合法域名，当action参数是get时不需要此字段。
     */
    @SerializedName("uploaddomain")
    private List<String> uploadDomain;
    /**
     * downloadFile合法域名，当action参数是get时不需要此字段。
     */
    @SerializedName("downloaddomain")
    private List<String> downloadDomain;
    /**
     * 小程序业务域名，当action参数是get时不需要此字段。
     */
    @SerializedName("webviewdomain")
    private List<String> webViewDomain;

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }

    public static WechatMiniDomainAction fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniDomainAction.class);
    }

}
