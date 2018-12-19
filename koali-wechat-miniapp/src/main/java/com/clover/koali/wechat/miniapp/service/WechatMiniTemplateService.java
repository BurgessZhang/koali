package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.WechatMiniTemplateAddResult;
import com.clover.koali.wechat.miniapp.bean.WechatMiniTemplateLibraryGetResult;
import com.clover.koali.wechat.miniapp.bean.WechatMiniTemplateLibraryListResult;
import com.clover.koali.wechat.miniapp.bean.WechatMiniTemplateListResult;

import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WechatMiniTemplateService.java
 * @time 13:27/2018-12-19
 * @desc 模板消息
 */
public interface WechatMiniTemplateService {

    //获取小程序模板库标题列表
    String TEMPLATE_LIBRARY_LIST_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list";

    //获取模板库某个模板标题下关键词库
    String TEMPLATE_LIBRARY_KEYWORD_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get";

    //组合模板并添加至帐号下的个人模板库
    String TEMPLATE_ADD_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add";

    //获取帐号下已存在的模板列表
    String TEMPLATE_LIST_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list";

    //删除帐号下的某个模板
    String TEMPLATE_DEL_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/del";

    /**获取小程序模板库标题列表*/
    WechatMiniTemplateLibraryListResult findTemplateLibraryList(int offset, int count);

    /**获取模板库某个模板标题下关键词库*/
    WechatMiniTemplateLibraryGetResult findTemplateLibraryKeywordList(String id);

    /**组合模板并添加至账号下的个人模板库*/
    WechatMiniTemplateAddResult addTemplate(String id, List<Integer> keywordIdList);

    /**获取账号下已存在的模板列表*/
    WechatMiniTemplateListResult findTemplateList(int offset, int count);

    /**删除账号下的某个模板*/
    boolean deleteTemplate(String templateId);
}
