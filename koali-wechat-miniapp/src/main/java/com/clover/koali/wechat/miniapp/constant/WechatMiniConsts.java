package com.clover.koali.wechat.miniapp.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.constant
 * @file WechatMiniConsts.java
 * @time 15:01/2018-12-19
 * @desc 微信开发所使用到的常量类
 */
public class WechatMiniConsts {

    /**
     * 微信接口返回的参数errcode.
     */
    public static final String ERRCODE = "errcode";

    /**
     * 素材类型.
     */
    public static class MediaType {
        /**
         * 图片.
         */
        public static final String IMAGE = "image";
    }

    /**
     * 消息格式.
     */
    public static class MsgDataFormat {
        public static final String XML = "XML";
        public static final String JSON = "JSON";
    }

    /**
     * 客服消息的消息类型.
     */
    public static class KefuMsgType {
        /**
         * 文本消息.
         */
        public static final String TEXT = "text";
        /**
         * 图片消息.
         */
        public static final String IMAGE = "image";
        /**
         * 图文链接.
         */
        public static final String LINK = "link";
        /**
         * 小程序卡片消息.
         */
        public static final String MA_PAGE = "miniprogrampage";
    }

    public static final class ErrorCode {
        /**
         * 40001 获取access_token时AppSecret错误，或者access_token无效.
         */
        public static final int ERR_40001 = 40001;

        /**
         * 42001 access_token超时.
         */
        public static final int ERR_42001 = 42001;

        /**
         * 40014 不合法的access_token，请开发者认真比对access_token的有效性（如是否过期）.
         */
        public static final int ERR_40014 = 40014;
    }

}
