package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniJsapiSignature;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniJsapiService.java
 * @time 14:36/2018-12-19
 * @desc jsapi相关接口
 */
public interface WechatMiniJsapiService {

    /**
     * 获得jsapi_ticket的url
     */
    String GET_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi";

    /**
     * 获得jsapi_ticket,不强制刷新jsapi_ticket
     *
     * @see #getJsapiTicket(boolean)
     */
    String getJsapiTicket();

    /**
     * <pre>
     * 获得jsapi_ticket
     * 获得时会检查jsapiToken是否过期，如果过期了，那么就刷新一下，否则就什么都不干
     *
     * 详情请见：http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115&token=&lang=zh_CN
     * </pre>
     *
     * @param forceRefresh 强制刷新
     */
    String getJsapiTicket(boolean forceRefresh);

    /**
     * <pre>
     * 创建调用jsapi时所需要的签名
     *
     * 详情请见：http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115&token=&lang=zh_CN
     * </pre>
     */
    WechatMiniJsapiSignature createJsapiSignature(String url);

}
