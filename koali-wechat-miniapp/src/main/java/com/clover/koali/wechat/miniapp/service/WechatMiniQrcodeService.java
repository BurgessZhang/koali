package com.clover.koali.wechat.miniapp.service;

import java.io.File;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniQrcodeService.java
 * @time 14:15/2018-12-19
 * @desc 二维码相关操作接口
 */
public interface WechatMiniQrcodeService {

    String CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode";
    String GET_WXACODE_URL = "https://api.weixin.qq.com/wxa/getwxacode";
    String GET_WXACODE_UNLIMIT_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit";

    /**获取小程序页面二维码*/
    File createQrcode(String path,int width);
    File createQrcode(String path);

    File createWechatMiniCode(String path, int width);

    File createWechatMiniCode(String path);

    File createWechatMiniCodeUnlimit(String scene, String page);
}
