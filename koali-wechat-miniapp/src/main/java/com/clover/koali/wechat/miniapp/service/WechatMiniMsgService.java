package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniKefuMessage;
import com.clover.koali.wechat.miniapp.bean.WechatMiniTemplateMessage;
import com.clover.koali.wechat.miniapp.bean.WechatMiniUniformMessage;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniMsgService.java
 * @time 14:24/2018-12-19
 * @desc 消息发送接口
 */
public interface WechatMiniMsgService {

    String KEFU_MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
    String TEMPLATE_MSG_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send";
    String UNIFORM_MSG_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send";

    /**发送客服消息*/
    boolean sendKefuMsg(WechatMiniKefuMessage message);

    /**发送模板消息*/
    void sendTemplateMsg(WechatMiniTemplateMessage templateMessage);


    /**下发小程序和公众号统一的服务消息*/
    void sendUniformMsg(WechatMiniUniformMessage uniformMessage);

}
