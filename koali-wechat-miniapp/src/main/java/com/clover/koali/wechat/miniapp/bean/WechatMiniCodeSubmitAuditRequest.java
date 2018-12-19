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
 * @file WechatMiniCodeSubmitAuditRequest.java
 * @time 14:45/2018-12-19
 * @desc
 */
@Data
@Builder
public class WechatMiniCodeSubmitAuditRequest implements Serializable {

    /**
     * 提交审核项的一个列表（至少填写1项，至多填写5项）
     */
    @SerializedName("item_list")
    private List<WechatMiniCategory> itemList;

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
