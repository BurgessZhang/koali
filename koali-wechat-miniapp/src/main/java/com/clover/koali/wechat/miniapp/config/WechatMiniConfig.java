package com.clover.koali.wechat.miniapp.config;

import com.clover.koali.wechat.miniapp.bean.WechatMiniAccessToken;

import java.util.concurrent.locks.Lock;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.config
 * @file WechatMiniConfig.java
 * @time 14:11/2018-12-19
 * @desc 小程序配置
 */
public interface WechatMiniConfig {

    String getAccessToken();

    Lock getAccessTokenLock();

    boolean isAccessTokenExpired();

    /**
     * 强制将access token过期掉
     */
    void expireAccessToken();

    /**
     * 应该是线程安全的
     *
     * @param accessToken 要更新的WxAccessToken对象
     */
    void updateAccessToken(WechatMiniAccessToken accessToken);

    /**
     * 应该是线程安全的
     *
     * @param accessToken      新的accessToken值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    void updateAccessToken(String accessToken, int expiresInSeconds);

    String getJsapiTicket();

    Lock getJsapiTicketLock();

    boolean isJsapiTicketExpired();

    /**
     * 强制将jsapi ticket过期掉
     */
    void expireJsapiTicket();

    /**
     * 应该是线程安全的
     *
     * @param jsapiTicket      新的jsapi ticket值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    void updateJsapiTicket(String jsapiTicket, int expiresInSeconds);

    String getAppid();

    String getSecret();

    String getToken();

    String getAesKey();

    String getMsgDataFormat();

    long getExpiresTime();

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getHttpProxyUsername();

    String getHttpProxyPassword();

    /**
     * 是否自动刷新token
     */
    boolean autoRefreshToken();
}
