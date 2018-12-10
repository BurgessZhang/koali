package com.clover.koali.common.http;

import java.util.Map;
import java.util.Set;

/**
 * @project koali-common
 * @package com.clover.koali.common.http
 * @file IHttpRequest.java
 * @author 番薯(Koali)
 * @time 15:10:43/2018-12-07
 * @desc http请求接口
 */
public interface IHttpRequest {

	/** 无参get请求 */
	String doGet(String url);

	/** 带参get请求 */
	String doGet(String url, Map<String, String> params);

	/** 带参get请求，自定义请求头 */
	String doGet(String url, Map<String, String> params, Map<String, String> headerMap);

	/** 无参post请求 */
	String doPost(String url);

	/** 带参post请求 */
	String doPost(String url, Map<String, String> params);

	/** 带参post请求,自定义请求头 */
	String doPost(String url, Map<String, String> params, Map<String, String> headerMap);

	/**
	 * @file IHttpRequest.java
	 * @author 番薯(Koali)
	 * @time 15:32:39/2018-12-07
	 * @desc 构造url参数
	 * @param reqUrl 请求url
	 * @param params 参数
	 * @return
	 */
	default String buildUrl(String reqUrl, Map<String, String> params) {
		if (null == params) {
			return reqUrl;
		}
		StringBuilder query = new StringBuilder();
		Set<String> set = params.keySet();
		for (String key : set) {
			query.append(String.format("%s=%s&", key, params.get(key)));
		}
		return reqUrl + "?" + query.toString();
	}

}
