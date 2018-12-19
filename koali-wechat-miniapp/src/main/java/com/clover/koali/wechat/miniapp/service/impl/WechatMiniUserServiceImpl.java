package com.clover.koali.wechat.miniapp.service.impl;

import com.clover.koali.wechat.miniapp.bean.WeChatMiniJscode2Session;
import com.clover.koali.wechat.miniapp.bean.WechatMiniPhoneNumberInfo;
import com.clover.koali.wechat.miniapp.bean.WechatMiniUserInfo;
import com.clover.koali.wechat.miniapp.config.WechatMiniConfig;
import com.clover.koali.wechat.miniapp.service.WechatMiniService;
import com.clover.koali.wechat.miniapp.service.WechatMiniUserService;
import com.clover.koali.wechat.miniapp.util.WechatMiniCryptUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service.impl
 * @file WechatMiniUserServiceImpl.java
 * @time 15:16/2018-12-19
 * @desc 小程序用户serivce接口实现
 */
public class WechatMiniUserServiceImpl implements WechatMiniUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatMiniUserServiceImpl.class);

    private WechatMiniService wechatMiniService;

    public WechatMiniUserServiceImpl(WechatMiniService wechatMiniService) {
        this.wechatMiniService = wechatMiniService;
    }

    @Override
    public WeChatMiniJscode2Session getSessionInfo(String jsCode) {
        return wechatMiniService.jsCode2SessionInfo(jsCode);
    }

    @Override
    public WechatMiniUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        return WechatMiniUserInfo.fromJson(WechatMiniCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
    }

    @Override
    public void setUserStorage(Map<String, String> kvMap, String sessionKey, String openid) {
        final WechatMiniConfig config = this.wechatMiniService.getWxMaConfig();
        JsonObject param = new JsonObject();
        JsonArray array = new JsonArray();
        for (Map.Entry<String, String> e : kvMap.entrySet()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", e.getKey());
            jsonObject.addProperty("value", e.getValue());
            array.add(jsonObject);
        }
        param.add("kv_list", array);
        String params = param.toString();
        String signature = SignUtils.createHmacSha256Sign(params, sessionKey);
        String url = String.format("https://api.weixin.qq.com/wxa/set_user_storage" +
                        "?appid=%s&signature=%s&openid=%s&sig_method=%s",
                config.getAppid(), signature, openid, "hmac_sha256");
        String result = this.wechatMiniService.post(url, params);
        WechatMiniError error = WxError.fromJson(result);
        if (error.getErrorCode() != 0) {
            throw new WxErrorException(error);
        }
    }

    @Override
    public WechatMiniPhoneNumberInfo getPhonenoInfo(String sessionKey, String encryptedData, String ivStr) {
        return null;
    }

    @Override
    public boolean checkUserInfo(String sessionKey, String rawData, String signature) {
        return false;
    }
}
