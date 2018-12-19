package com.clover.koali.wechat.miniapp.bean;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniCodeAuditStatus.java
 * @time 14:46/2018-12-19
 * @desc
 */
@Data
@Builder
public class WechatMiniCodeAuditStatus implements Serializable {

    /**
     * 审核 ID
     */
    @SerializedName(value = "auditId", alternate = {"auditid"})
    private Long auditId;
    /**
     * 审核状态，其中0为审核成功，1为审核失败，2为审核中
     */
    private Integer status;
    /**
     * 当status=1，审核被拒绝时，返回的拒绝原因
     */
    private String reason;

    public static WechatMiniCodeAuditStatus fromJson(String json) {
        return new GsonBuilder().create().fromJson(json, WechatMiniCodeAuditStatus.class);
    }
}
