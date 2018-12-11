package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniToken;
import com.clover.koali.wechat.miniapp.util.WechatMiniException;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatAccessTokenSerivce.java
 * @time 13:48/2018-12-11
 * @desc access_token service接口
 */
public interface WechatAccessTokenSerivce {

    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    /**获取accessToken*/
    WechatMiniToken getAccessToken(String appId,String appSecret) throws WechatMiniException;

    /**更新accessToken*/
    WechatMiniToken updateAccessToken() throws WechatMiniException;

}
