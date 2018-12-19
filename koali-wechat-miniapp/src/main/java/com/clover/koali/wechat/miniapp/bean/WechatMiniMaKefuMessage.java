package com.clover.koali.wechat.miniapp.bean;

import com.clover.koali.wechat.miniapp.builder.ImageMessageBuilder;
import com.clover.koali.wechat.miniapp.builder.LinkMessageBuilder;
import com.clover.koali.wechat.miniapp.builder.MaPageMessageBuilder;
import com.clover.koali.wechat.miniapp.builder.TextMessageBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.bean
 * @file WechatMiniMaKefuMessage.java
 * @time 14:58/2018-12-19
 * @desc
 */
@Data
public class WechatMiniMaKefuMessage implements Serializable {

    @SerializedName("touser")
    private String toUser;

    @SerializedName("msgtype")
    private String msgType;

    @SerializedName("text")
    private KfText text;

    @SerializedName("image")
    private KfImage image;

    @SerializedName("link")
    private KfLink link;

    @SerializedName("miniprogrampage")
    private KfMaPage maPage;

    @Data
    @AllArgsConstructor
    public static class KfText {
        private String content;
    }

    @Data
    @AllArgsConstructor
    public static class KfImage {
        @SerializedName("media_id")
        private String mediaId;
    }

    @Data
    @Builder
    public static class KfLink {
        private String title;
        private String description;
        private String url;

        @SerializedName("thumb_url")
        private String thumbUrl;
    }

    @Data
    @Builder
    public static class KfMaPage {
        private String title;

        @SerializedName("pagepath")
        private String pagePath;

        @SerializedName("thumb_media_id")
        private String thumbMediaId;
    }

    /**
     * 获得文本消息builder.
     */
    public static TextMessageBuilder newTextBuilder() {
        return new TextMessageBuilder();
    }

    /**
     * 获得图片消息builder.
     */
    public static ImageMessageBuilder newImageBuilder() {
        return new ImageMessageBuilder();
    }

    /**
     * 获得图文链接消息builder.
     */
    public static LinkMessageBuilder newLinkBuilder() {
        return new LinkMessageBuilder();
    }

    /**
     * 获得图文链接消息builder.
     */
    public static MaPageMessageBuilder newMaPageBuilder() {
        return new MaPageMessageBuilder();
    }

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }
}
