package com.clover.koali.wechat.miniapp.builder;


import com.clover.koali.wechat.miniapp.bean.WechatMiniMaKefuMessage;
import com.clover.koali.wechat.miniapp.constant.WechatMiniConsts;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.builder
 * @file LinkMessageBuilder.java
 * @time 15:03/2018-12-19
 * @desc
 */
public class LinkMessageBuilder extends BaseBuilder<LinkMessageBuilder> {

    private String title;
    private String description;
    private String url;
    private String thumbUrl;

    public LinkMessageBuilder() {
        this.msgType = WechatMiniConsts.KefuMsgType.LINK;
    }

    public LinkMessageBuilder title(String title) {
        this.title = title;
        return this;
    }

    public LinkMessageBuilder description(String description) {
        this.description = description;
        return this;
    }

    public LinkMessageBuilder url(String url) {
        this.url = url;
        return this;
    }

    public LinkMessageBuilder thumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    @Override
    public WechatMiniMaKefuMessage build() {
        WechatMiniMaKefuMessage m = super.build();
        m.setLink(WechatMiniMaKefuMessage.KfLink.builder().title(this.title)
                .description(this.description)
                .url(this.url)
                .thumbUrl(this.thumbUrl)
                .build()
        );
        return m;
    }
}
