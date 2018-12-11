package com.clover.koali.wechat.miniapp.util;


/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.util
 * @file WechatMiniException.java
 * @time 13:55/2018-12-11
 * @desc 自定义异常
 */
public class WechatMiniException extends Exception {

    private String errorMsg;

    public WechatMiniException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public WechatMiniException(String message, String errorMsg) {
        super(message);
        this.errorMsg = errorMsg;
    }

    public WechatMiniException(String message, Throwable cause, String errorMsg) {
        super(message, cause);
        this.errorMsg = errorMsg;
    }

    public WechatMiniException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }

    public WechatMiniException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
