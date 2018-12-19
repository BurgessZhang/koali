package com.clover.koali.wechat.miniapp.builder;

import com.clover.koali.wechat.miniapp.bean.WechatMiniMaKefuMessage;
import com.clover.koali.wechat.miniapp.constant.WechatMiniConsts;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.builder
 * @file TextMessageBuilder.java
 * @time 15:11/2018-12-19
 * @desc
 */
public class TextMessageBuilder extends BaseBuilder<TextMessageBuilder> {

    private String content;

    public TextMessageBuilder() {
        this.msgType = WechatMiniConsts.KefuMsgType.TEXT;
    }

    public TextMessageBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public WechatMiniMaKefuMessage build() {
        WechatMiniMaKefuMessage m = super.build();
        m.setText(new WechatMiniMaKefuMessage.KfText(this.content));
        return m;
    }
}
