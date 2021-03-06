package com.clover.koali.wechat.miniapp.bean;


import com.google.gson.GsonBuilder;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniUniformMessage.java
 * @time 14:30/2018-12-19
 * @desc 模板消息
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WechatMiniUniformMessage implements Serializable {

    /**
     * 是否发送公众号模版消息，否则发送小程序模版消息.
     */
    private boolean isMpTemplateMsg;

    /**
     * 用户openid.
     * 可以是小程序的openid，也可以是mp_template_msg.appid对应的公众号的openid
     */
    private String toUser;

    /**
     * 公众号appid，要求与小程序有绑定且同主体.
     */
    private String appid;

    /**
     * 公众号或小程序模板ID.
     */
    private String templateId;

    /**
     * 公众号模板消息所要跳转的url.
     */
    private String url;

    /**
     * 小程序页面路径.
     */
    private String page;

    /**
     * 小程序模板消息formid.
     */
    private String formId;

    /**
     * 公众号模板消息所要跳转的小程序，小程序的必须与公众号具有绑定关系.
     */
    private MiniProgram miniProgram;

    /**
     * 小程序模板数据.
     */
    private List<WechatMiniTemplateData> data;

    /**
     * 模板需要放大的关键词，不填则默认无放大.
     */
    private String emphasisKeyword;

    public WechatMiniUniformMessage addData(WechatMiniTemplateData datum) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(datum);

        return this;
    }

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MiniProgram implements Serializable {
        private static final long serialVersionUID = -7945254706501974849L;

        private String appid;
        private String pagePath;

        /**
         * 是否使用path，否则使用pagepath.
         * 加入此字段是基于微信官方接口变化多端的考虑
         */
        private boolean usePath = false;
    }
}
