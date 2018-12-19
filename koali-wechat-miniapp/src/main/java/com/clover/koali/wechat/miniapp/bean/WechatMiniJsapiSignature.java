package com.clover.koali.wechat.miniapp.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniJsapiSignature.java
 * @time 14:37/2018-12-19
 * @desc
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WechatMiniJsapiSignature implements Serializable {

    private String appId;

    private String nonceStr;

    private long timestamp;

    private String url;

    private String signature;
}
