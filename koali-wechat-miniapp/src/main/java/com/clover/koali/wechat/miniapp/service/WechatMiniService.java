package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WeChatMiniJscode2Session;
import com.clover.koali.wechat.miniapp.config.WechatMiniConfig;
import com.clover.koali.wechat.miniapp.util.WechatMiniRequestExecutor;

import java.io.File;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniService.java
 * @time 13:55/2018-12-19
 * @desc 小程序service接口
 */
public interface WechatMiniService {

    /**
     * 获取access_token.
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    String IMG_SEC_CHECK_URL = "https://api.weixin.qq.com/wxa/img_sec_check";

    /**校验一张图片是否含有违法违规内容*/
    boolean imgSecCheck(File file);

    /**获取登陆后的session信息*/
    WeChatMiniJscode2Session jsCode2SessionInfo(String JsCode);

    /**验证消息的确来自微信服务器*/
    boolean checkSignature(String timestamp,String nonce,String signature);

    /**获取access_token,不强制刷新access_token*/
    String getAccessToken();

    /** 获取access_token，本方法线程安全.且在多线程同时刷新时只刷新一次，避免超出2000次/日的调用次数上限*/
    String getAccessToken(boolean forceRefresh);

    /**当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的GET请求*/
    String get(String url,String queryParam);

    /**当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的POST请求*/
    String post(String url, String postData);

    /**Service没有实现某个API的时候，可以用这个，*/
    <T, E> T execute(WechatMiniRequestExecutor<T, E> executor, String uri, E data);

    /**设置当微信系统响应系统繁忙时，要等待多少 retrySleepMillis(ms) * 2^(重试次数 - 1) 再发起重试.*/
    void setRetrySleepMillis(int retrySleepMillis);

    /**设置当微信系统响应系统繁忙时，最大重试次数.*/
    void setMaxRetryTimes(int maxRetryTimes);

    /**获取WxMaConfig 对象.*/
    WechatMiniConfig getWxMaConfig();

    /**注入 {@link WechatMiniConfig} 的实现*/
    void setWxMaConfig(WechatMiniConfig wxConfigProvider);

    /**返回消息（客服消息和模版消息）发送接口方法实现类，以方便调用其各个接口*/
    WechatMiniMsgService getMsgService();

    /**返回素材相关接口方法的实现类对象，以方便调用其各个接口*/
    WechatMiniMediaService getMediaService();

    /**返回用户相关接口方法的实现类对象，以方便调用其各个接口*/
    WechatMiniUserService getUserService();

    /**返回二维码相关接口方法的实现类对象，以方便调用其各个接口*/
    WechatMiniQrcodeService getQrcodeService();

    /**返回模板配置相关接口方法的实现类对象, 以方便调用其各个接口*/
    WechatMiniTemplateService getTemplateService();

    /**数据分析相关查询服务*/
    WechatMiniAnalysisService getAnalysisService();

    /**返回代码操作相关的 API*/
    WechatMiniCodeService getCodeService();

    /**返回jsapi操作相关的 API服务类对象*/
    WechatMiniJsapiService getJsapiService();

    /**小程序修改服务器地址、成员管理 API*/
    WechatMiniSettingService getSettingService();

    /**初始化http请求对象*/
    void initHttp();

    /**请求http请求相关信息*/
    RequestHttp getRequestHttp();

}
