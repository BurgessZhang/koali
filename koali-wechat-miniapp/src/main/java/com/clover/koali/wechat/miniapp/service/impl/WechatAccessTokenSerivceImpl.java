package com.clover.koali.wechat.miniapp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.clover.koali.common.date.DateFormatUtils;
import com.clover.koali.common.util.StringUtils;
import com.clover.koali.wechat.common.http.HttpUtils;
import com.clover.koali.wechat.miniapp.bean.WechatMiniToken;
import com.clover.koali.wechat.miniapp.constant.WechatExceptionConstant;
import com.clover.koali.wechat.miniapp.service.WechatAccessTokenSerivce;
import com.clover.koali.wechat.miniapp.util.WechatMiniAppInfo;
import com.clover.koali.wechat.miniapp.util.WechatMiniException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service.impl
 * @file WechatAccessTokenSerivceImpl.java
 * @time 13:49/2018-12-11
 * @desc access_token service接口 实现
 */
public class WechatAccessTokenSerivceImpl implements WechatAccessTokenSerivce {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatAccessTokenSerivceImpl.class);

    /**
     * @param '[appId 小程序AppId, appSecret 小程序appSecret]
     * @return com.clover.koali.wechat.miniapp.bean.WechatMiniToken
     * @file WechatAccessTokenSerivceImpl.java
     * @method getAccessToken
     * @desc 获取accessToken
     * @author 番薯(Koali)
     * @date 13:51/2018-12-11
     */
    @Override
    public WechatMiniToken getAccessToken(String appId, String appSecret) throws WechatMiniException {
        LOGGER.debug("[class: WechatAccessTokenSerivceImpl.java]-[method: getAccessToken]-[function: {}] [参数/结果]: {}", "获取accessToken", appId, appSecret);
        if (StringUtils.isBlank(appId)) {
            throw new WechatMiniException(WechatExceptionConstant.WECHAT_APPID_IS_NULL);
        }
        if (StringUtils.isBlank(appSecret)) {
            throw new WechatMiniException(WechatExceptionConstant.WECHAT_APPSECRET_IS_NULL);
        }

        Map<String, String> params = new HashMap<>(4);

        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("grant_type", "client_credential");

        String result = HttpUtils.doGet(GET_ACCESS_TOKEN_URL, params);

        LOGGER.debug("[class: WechatAccessTokenSerivceImpl.java]-[method: getAccessToken]-[function: {}] [参数/结果]: {}", "获取accessToken", result);

        JSONObject json = JSONObject.parseObject(result);

        if (!json.containsKey("access_token")) {
            throw new WechatMiniException(result);
        }

        String accessToken = json.getString("access_token");
        long expiresIn = json.getLong("expires_in");

        expiresIn = DateFormatUtils.currentTimestamp() + expiresIn * 1000;

        WechatMiniAppInfo.appId = appId;
        WechatMiniAppInfo.appSecret = appSecret;
        WechatMiniAppInfo.accessToken = accessToken;
        WechatMiniAppInfo.expiresIn = expiresIn;

        WechatMiniToken token = new WechatMiniToken();

        token.setAccessToken(accessToken);
        token.setAppId(appId);
        token.setAppSecret(appSecret);
        token.setExpiresIn(expiresIn);

        return token;
    }

    /**
     * @file WechatAccessTokenSerivceImpl.java
     * @method updateAccessToken
     * @desc 更新access_token
     * @author 番薯(Koali)
     * @date  14:20/2018-12-11
     * @param '[]
     * @return com.clover.koali.wechat.miniapp.bean.WechatMiniToken
     */
    @Override
    public synchronized WechatMiniToken updateAccessToken() throws WechatMiniException {

        WechatMiniToken wechatMiniToken = new WechatMiniToken();

        //过期时间与当前时间相差多久
        long differTimeLong = WechatMiniAppInfo.expiresIn - System.currentTimeMillis();
        //accessToken有效期小于10分钟时则更新
        if (differTimeLong > 10 * 60 * 1000){
            wechatMiniToken.setExpiresIn(WechatMiniAppInfo.expiresIn);
            wechatMiniToken.setAppSecret(WechatMiniAppInfo.appSecret);
            wechatMiniToken.setAppId(WechatMiniAppInfo.appId);
            wechatMiniToken.setAccessToken(WechatMiniAppInfo.accessToken);
            return wechatMiniToken;
        }

        return getAccessToken(WechatMiniAppInfo.appId,WechatMiniAppInfo.appSecret);
    }
}
