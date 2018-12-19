package com.clover.koali.wechat.miniapp.builder;

import com.clover.koali.wechat.miniapp.bean.WechatMiniMaKefuMessage;
import com.clover.koali.wechat.miniapp.constant.WechatMiniConsts;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.builder
 * @file ImageMessageBuilder.java
 * @time 14:59/2018-12-19
 * @desc
 */
public class ImageMessageBuilder extends BaseBuilder<ImageMessageBuilder> {

    private String mediaId;

    public ImageMessageBuilder() {
        this.msgType = WechatMiniConsts.KefuMsgType.IMAGE;
    }

    public ImageMessageBuilder mediaId(String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    @Override
    public WechatMiniMaKefuMessage build() {
        WechatMiniMaKefuMessage m = super.build();
        m.setImage(new WechatMiniMaKefuMessage.KfImage(this.mediaId));
        return m;
    }
}
