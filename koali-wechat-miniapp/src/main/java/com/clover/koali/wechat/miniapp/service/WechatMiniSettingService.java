package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniDomainAction;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniSettingService.java
 * @time 13:49/2018-12-19
 * @desc 小程序修改服务器地址，成员管理
 */
public interface WechatMiniSettingService {

    /**
     * 修改服务器地址：https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489138143_WPbOO&token=&lang=zh_CN
     * access_token 为 authorizer_access_token
     */
    String MODIFY_DOMAIN_URL = "https://api.weixin.qq.com/wxa/modify_domain";
    String SET_WEB_VIEW_DOMAIN_URL = "https://api.weixin.qq.com/wxa/setwebviewdomain";
    /**
     * 小程序成员管理：https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140588_nVUgx&token=&lang=zh_CN
     * access_token 为 authorizer_access_token
     */
    String BIND_TESTER_URL = "https://api.weixin.qq.com/wxa/bind_tester";
    String UNBIND_TESTER_URL = "https://api.weixin.qq.com/wxa/unbind_tester";

    /**操作服务器域名*/
    WechatMiniDomainAction modifyDomain(WechatMiniDomainAction domainAction);

    //设置小程序业务域名
    WechatMiniDomainAction setWebViewDomain(WechatMiniDomainAction domainAction);

    //绑定微信用户为小程序体验者
    void bindTester(String wechatId);

    //解绑微信小程序的体验者
    void unbindTester(String wechatId);
}
