package com.clover.koali.wechat.miniapp.builder;

import com.clover.koali.wechat.miniapp.bean.WechatMiniMaKefuMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.builder
 * @file BaseBuilder.java
 * @time 14:57/2018-12-19
 * @desc
 */
public class BaseBuilder<T> {

    protected String msgType;
    protected String toUser;

    @SuppressWarnings("unchecked")
    public T toUser(String toUser) {
        this.toUser = toUser;
        return (T) this;
    }

    /**
     * 构造器方法.
     */
    public WechatMiniMaKefuMessage build() {
        WechatMiniMaKefuMessage m = new WechatMiniMaKefuMessage();
        m.setMsgType(this.msgType);
        m.setToUser(this.toUser);
        return m;
    }
}
