package com.clover.koali.common.http.client;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clover.koali.common.http.IHttpRequest;

/**
 * @author burgess.zhang
 * @project koali
 * @package com.clover.koali.common.http.client
 * @file HttpClientFactory.java
 * @time 2018-12-07 13:42
 * @desc httpClient 请求实现
 */
public class HttpClientRequestImpl implements IHttpRequest{

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientRequestImpl.class);
    
	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 无参get请求
	 * @param url 请求地址
	 * @return 请求响应值
	 * @see com.clover.koali.common.http.IHttpRequest#doGet(java.lang.String)
	 */
	@Override
	public String doGet(String url) {
		LOGGER.debug("[class: HttpClientRequestImpl.java]-[method: doGet]-[function: {}]-[params: url {}]", "无参get请求", url);
		
		return doGet(url, null, null);
	}

	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 带参get请求
	 * @param url 请求地址
	 * @param params 请求参数
	 * @return 请求响应值
	 * @see com.clover.koali.common.http.IHttpRequest#doGet(java.lang.String, java.util.Map)
	 */
	@Override
	public String doGet(String url, Map<String, String> params) {
		LOGGER.debug("[class: HttpClientRequestImpl.java]-[method: doGet]-[function: {}]-[params: url, params {}]", "带参get请求", url);
		return doGet(url,params,null);
	}

	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 带参get请求，自定义请求头
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param headerMap 自定义请求头
	 * @return
	 * @see com.clover.koali.common.http.IHttpRequest#doGet(java.lang.String, java.util.Map, java.util.Map)
	 */
	@Override
	public String doGet(String url, Map<String, String> params, Map<String, String> headerMap) {
		url = buildUrl(url, params);
		LOGGER.debug(
				"[class: HttpClientRequestImpl.java]-[method: doGet]-[function: {}]-[params: url, params, headerMap {}]",
				"带参get请求，自定义请求头", headerMap);
		return HttpClientUtils.getUrlContent(url, headerMap);
	}

	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 无参post请求
	 * @param url 请求地址
	 * @return
	 * @see com.clover.koali.common.http.IHttpRequest#doPost(java.lang.String)
	 */
	@Override
	public String doPost(String url) {
		LOGGER.debug("[class: HttpClientRequestImpl.java]-[method: doPost]-[function: {}]-[params: url {}]", "无参post请求",
				url);
		return doPost(url,null,null);
	}

	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 带参post请求
	 * @param url 请求地址
	 * @param params 请求参数
	 * @return
	 * @see com.clover.koali.common.http.IHttpRequest#doPost(java.lang.String, java.util.Map)
	 */
	@Override
	public String doPost(String url, Map<String, String> params) {
		LOGGER.debug("[class: HttpClientRequestImpl.java]-[method: doPost]-[function: {}]-[params: url, params {}]",
				"带参post请求", params);
		return doPost(url,params,null);
	}

	/**
	 * @file HttpClientRequestImpl.java
	 * @author 番薯(Koali)
	 * @time 15:19:29/2018-12-07
	 * @desc 带参post请求,自定义请求头
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param headerMap 自定义请求头
	 * @return
	 * @see com.clover.koali.common.http.IHttpRequest#doPost(java.lang.String, java.util.Map, java.util.Map)
	 */
	@Override
	public String doPost(String url, Map<String, String> params, Map<String, String> headerMap) {
		LOGGER.debug(
				"[class: HttpClientRequestImpl.java]-[method: doPost]-[function: {}]-[params: url, params, headerMap {}]",
				"带参post请求,自定义请求头", headerMap);
		return HttpClientUtils.postForEntity(url, params, headerMap);
	}

}
