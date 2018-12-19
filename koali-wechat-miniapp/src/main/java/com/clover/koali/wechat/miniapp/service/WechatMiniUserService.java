package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WeChatMiniJscode2Session;
import com.clover.koali.wechat.miniapp.bean.WechatMiniPhoneNumberInfo;
import com.clover.koali.wechat.miniapp.bean.WechatMiniUserInfo;

import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatUserService.java
 * @time 14:33/2018-12-11
 * @desc 小程序用户servic接口
 */
public interface WechatMiniUserService {

    /**获取授权用户信息*/
    WeChatMiniJscode2Session getSessionInfo(String jsCode);

    /**解密用户敏感数据*/
    WechatMiniUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr);

    /**上报用户数据*/
    void setUserStorage(Map<String, String> kvMap, String sessionKey, String openid);

    /**解码用户手机号信息*/
    WechatMiniPhoneNumberInfo getPhonenoInfo(String sessionKey, String encryptedData, String ivStr);

    /**验证用户信息完整性*/
    boolean checkUserInfo(String sessionKey,String rawData,String signature);
}
