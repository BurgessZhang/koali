package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WeChatJscode2Session;
import com.clover.koali.wechat.miniapp.bean.WechatUserInfo;

import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatUserService.java
 * @time 14:33/2018-12-11
 * @desc 小程序用户servic接口
 */
public interface WechatUserService {

    /**获取授权用户信息*/
    WeChatJscode2Session getSessionInfo(String jsCode);

    /**解密用户敏感数据*/
    WechatUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr);

    void setUserStorage(Map<String, String> kvMap, String sessionKey, String openid);
}
