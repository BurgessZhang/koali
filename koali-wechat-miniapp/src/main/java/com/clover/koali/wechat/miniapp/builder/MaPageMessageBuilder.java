package com.clover.koali.wechat.miniapp.builder;

import com.clover.koali.wechat.miniapp.bean.WechatMiniMaKefuMessage;
import com.clover.koali.wechat.miniapp.constant.WechatMiniConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.builder
 * @file MaPageMessageBuilder.java
 * @time 15:09/2018-12-19
 * @desc
 */
public class MaPageMessageBuilder extends BaseBuilder<MaPageMessageBuilder> {

    private String title;
    private String pagePath;
    private String thumbMediaId;

    public MaPageMessageBuilder() {
        this.msgType = WechatMiniConsts.KefuMsgType.MA_PAGE;
    }

    public MaPageMessageBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MaPageMessageBuilder pagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }

    public MaPageMessageBuilder thumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        return this;
    }

    @Override
    public WechatMiniMaKefuMessage build() {
        WechatMiniMaKefuMessage m = super.build();
        m.setMaPage(WechatMiniMaKefuMessage.KfMaPage.builder()
                .title(this.title)
                .pagePath(this.pagePath)
                .thumbMediaId(this.thumbMediaId)
                .build()
        );
        return m;
    }
}
