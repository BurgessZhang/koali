package com.clover.koali.wechat.miniapp.bean;

import com.clover.koali.wechat.common.enums.WechatType;
import com.google.gson.GsonBuilder;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniError.java
 * @time 15:26/2018-12-19
 * @desc  微信错误码
 */
@Data
@Builder
public class WechatMiniError implements Serializable {

    /**
     * 微信错误代码.
     */
    private int errorCode;

    /**
     * 微信错误信息.
     * （如果可以翻译为中文，就为中文）
     */
    private String errorMsg;

    /**
     * 微信接口返回的错误原始信息（英文）.
     */
    private String errorMsgEn;

    private String json;

    public static WechatMiniError fromJson(String json) {
        return fromJson(json, null);
    }

    public static WechatMiniError fromJson(String json, WechatType type) {
        final WechatMiniError wxError = new GsonBuilder().create().fromJson(json, WechatMiniError.class);
        if (StringUtils.isNotEmpty(wxError.getErrorMsg())) {
            wxError.setErrorMsgEn(wxError.getErrorMsg());
        }

        if (type == null) {
            return wxError;
        }

        if (type == WechatType.MP) {
            final String msg = WxMpErrorMsgEnum.findMsgByCode(wxError.getErrorCode());
            if (msg != null) {
                wxError.setErrorMsg(msg);
            }
        } else if (type == WechatType.CP) {
            final String msg = WxCpErrorMsgEnum.findMsgByCode(wxError.getErrorCode());
            if (msg != null) {
                wxError.setErrorMsg(msg);
            }
        }

        return wxError;
    }

    @Override
    public String toString() {
        if (this.json != null) {
            return this.json;
        }
        return "错误: Code=" + this.errorCode + ", Msg=" + this.errorMsg;
    }
}
