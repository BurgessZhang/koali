package com.clover.koali.wechat.miniapp.util;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.util
 * @file WechatMiniRequestExecutor.java
 * @time 14:08/2018-12-19
 * @desc http请求执行器
 */
public interface WechatMiniRequestExecutor<T, E> {

    T execute(String uri, E data)
}
