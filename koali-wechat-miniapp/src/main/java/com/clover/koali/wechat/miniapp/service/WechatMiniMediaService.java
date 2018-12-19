package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniMediaUploadResult;
import com.clover.koali.wechat.miniapp.bean.WechatMinidiaUploadResult;

import java.io.File;
import java.io.InputStream;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniMediaService.java
 * @time 14:31/2018-12-19
 * @desc 临时素材接口
 */
public interface WechatMiniMediaService {

    String MEDIA_UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?type=%s";
    String MEDIA_GET_URL = "https://api.weixin.qq.com/cgi-bin/media/get";


    /**
     * <pre>
     * 新增临时素材
     * 小程序可以使用本接口把媒体文件（目前仅支持图片）上传到微信服务器，用户发送客服消息或被动回复用户消息。
     * 详情请见: <a href="https://mp.weixin.qq.com/debug/wxadoc/dev/api/custommsg/material.html#新增临时素材">新增临时素材</a>
     * 接口url格式：https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
     * </pre>
     *
     * @param mediaType 媒体类型,
     * @param file      文件对象
     * @see #uploadMedia(String, String, InputStream)
     */
    WechatMinidiaUploadResult uploadMedia(String mediaType, File file);

    /**
     * <pre>
     * 新增临时素材
     * 小程序可以使用本接口把媒体文件（目前仅支持图片）上传到微信服务器，用户发送客服消息或被动回复用户消息。
     *
     * 详情请见: <a href="https://mp.weixin.qq.com/debug/wxadoc/dev/api/custommsg/material.html#新增临时素材">新增临时素材</a>
     * 接口url格式：https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
     * </pre>
     *
     * @param mediaType   媒体类型
     * @param fileType    文件类型
     * @param inputStream 输入流
     * @see #uploadMedia(java.lang.String, java.io.File)
     */
    WechatMiniMediaUploadResult uploadMedia(String mediaType, String fileType, InputStream inputStream);

    /**
     * <pre>
     * 获取临时素材
     * 小程序可以使用本接口获取客服消息内的临时素材（即下载临时的多媒体文件）。目前小程序仅支持下载图片文件。
     *
     * 详情请见: <a href="https://mp.weixin.qq.com/debug/wxadoc/dev/api/custommsg/material.html#获取临时素材">获取临时素材</a>
     * 接口url格式：https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     * </pre>
     *
     * @param mediaId 媒体Id
     * @return 保存到本地的临时文件
     */
    File getMedia(String mediaId);

}
