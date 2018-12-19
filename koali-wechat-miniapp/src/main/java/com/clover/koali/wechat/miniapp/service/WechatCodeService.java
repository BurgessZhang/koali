package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.*;

import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatCodeService.java
 * @time 14:39/2018-12-19
 * @desc 小程序代码管理相关
 */
public interface WechatCodeService {

    /**
     * 为授权的小程序帐号上传小程序代码
     */
    String COMMIT_URL = "https://api.weixin.qq.com/wxa/commit";
    String GET_QRCODE_URL = "https://api.weixin.qq.com/wxa/get_qrcode";
    String GET_CATEGORY_URL = "https://api.weixin.qq.com/wxa/get_category";
    String GET_PAGE_URL = "https://api.weixin.qq.com/wxa/get_page";
    String SUBMIT_AUDIT_URL = "https://api.weixin.qq.com/wxa/submit_audit";
    String GET_AUDIT_STATUS_URL = "https://api.weixin.qq.com/wxa/get_auditstatus";
    String GET_LATEST_AUDIT_STATUS_URL = "https://api.weixin.qq.com/wxa/get_latest_auditstatus";
    String RELEASE_URL = "https://api.weixin.qq.com/wxa/release";
    String CHANGE_VISIT_STATUS_URL = "https://api.weixin.qq.com/wxa/change_visitstatus";
    String REVERT_CODE_RELEASE_URL = "https://api.weixin.qq.com/wxa/revertcoderelease";
    String GET_SUPPORT_VERSION_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/getweappsupportversion";
    String SET_SUPPORT_VERSION_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/setweappsupportversion";
    String UNDO_CODE_AUDIT_URL = "https://api.weixin.qq.com/wxa/undocodeaudit";

    /**
     * 为授权的小程序帐号上传小程序代码（仅仅支持第三方开放平台）
     *
     * @param commitRequest 参数
     */
    void commit(WechatMiniCodeCommitRequest commitRequest) ;

    /**
     * 获取体验小程序的体验二维码
     * 文档地址：
     * https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140610_Uavc4&token=&lang=zh_CN
     *
     * @param path 指定体验版二维码跳转到某个具体页面（如果不需要的话，则不需要填path参数，可在路径后以“?参数”方式传入参数）
     * 具体的路径加参数需要urlencode（方法内部处理），比如page/index?action=1编码后得到page%2Findex%3Faction%3D1
     * @return 二维码 bytes
     */
    byte[] getQrCode(String path);

    /**
     * 获取授权小程序帐号的可选类目
     *
     * @return List<WxMaCategory>
     */
    List<WechatMiniCategory> getCategory();

    /**
     * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
     *
     * @return page_list 页面配置列表
     */
    List<String> getPage();

    /**
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     *
     * @param auditRequest 提交审核参数
     * @return 审核编号
     */
    long submitAudit(WechatMiniCodeSubmitAuditRequest auditRequest);

    /**
     * 查询某个指定版本的审核状态（仅供第三方代小程序调用）
     *
     * @param auditId 提交审核时获得的审核id
     * @return 审核状态
     */
    WechatMiniCodeAuditStatus getAuditStatus(long auditId);

    /**
     * 查询最新一次提交的审核状态（仅供第三方代小程序调用）
     *
     * @return 审核状态
     */
    WechatMiniCodeAuditStatus getLatestAuditStatus();

    /**
     * 发布已通过审核的小程序（仅供第三方代小程序调用）
     *
     */
    void release();

    /**
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     *
     * @param action 设置可访问状态，发布后默认可访问，close为不可见，open为可见
     */
    void changeVisitStatus(String action);

    /**
     * 小程序版本回退（仅供第三方代小程序调用）
     *
     */
    void revertCodeRelease();

    /**
     * 查询当前设置的最低基础库版本及各版本用户占比 （仅供第三方代小程序调用）
     *
     * @return 小程序版本分布信息
     */
    WechatMiniCodeVersionDistribution getSupportVersion();

    /**
     * 设置最低基础库版本（仅供第三方代小程序调用）
     *
     * @param version 版本
     */
    void setSupportVersion(String version);

    /**
     * 小程序审核撤回
     * 单个帐号每天审核撤回次数最多不超过1次，一个月不超过10次
     *
     */
    void undoCodeAudit();
}
