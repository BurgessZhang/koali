package com.clover.koali.wechat.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniToken;
import com.clover.koali.wechat.miniapp.service.WechatAccessTokenSerivce;
import com.clover.koali.wechat.miniapp.service.impl.WechatAccessTokenSerivceImpl;
import com.clover.koali.wechat.miniapp.util.WechatMiniException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.service
 * @file WechatAccessTokenSerivceTest.java
 * @time 14:12/2018-12-11
 * @desc
 */
public class WechatAccessTokenSerivceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatAccessTokenSerivceTest.class);

    //小程序AppId
    public static String appId = "wxb73b33f7fbb6d4f3";
    //小程序 AppSecret
    public static String appSecret = "12e64f1c0413dfad48a5543ac348b1e5";


    @Test
    public void getAccessToken(){
        WechatAccessTokenSerivce wechatAccessTokenSerivce = new WechatAccessTokenSerivceImpl();

        WechatMiniToken wechatMiniToken = null;
        try {
            wechatMiniToken = wechatAccessTokenSerivce.getAccessToken(appId,appSecret);
            System.out.println(wechatMiniToken.toString());
        } catch (WechatMiniException e) {
            e.printStackTrace();
        }


    }

}
