package com.clover.koali.common.http;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clover.koali.common.http.client.HttpClientRequestImpl;

/**
 * @project koali-common
 * @package com.clover.koali.common.http
 * @file HttpRequestFactory.java
 * @author 番薯(Koali)
 * @time 17:02:57/2018-12-07
 * @desc http请求
 */
public class HttpRequestFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestFactory.class);

	private static IHttpRequest httpRequest = null;

	/** 私有化构造方法 */
	private HttpRequestFactory() {
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:36:18/2018-12-07
	 * @desc 发送http请求
	 * @param httpType    请求类型(httpClient,okHttp) 默认httpClient
	 * @param requestType 请求方式(get,post)
	 * @param url         请求地址
	 * @param params      参数
	 * @param headers     请求头
	 * @return
	 */
	public static String sendReqeust(int httpType, String requestType, String url, Map<String, String> params,
			Map<String, String> headers) {
		initHttpRequest(httpType);
		if (HttpRequestConstant.HTTP_REQUEST_TYPE_GET.equals(requestType)) {
			// get请求
			return doGet(url, params, headers);
		} else if (HttpRequestConstant.HTTP_REQUEST_TYPE_POST.equals(requestType)) {
			// post请求
			return doPost(url, params, headers);
		}
		return null;
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:38:52/2018-12-07
	 * @desc 发送get请求
	 * @param httpType 请求类型(httpClient,okHttp) 默认httpClient
	 * @param url      请求地址
	 * @param params   参数
	 * @param headers  请求头
	 * @return
	 */
	public static String sendRequestByGet(int httpType, String url, Map<String, String> params,
			Map<String, String> headers) {
		initHttpRequest(httpType);
		return doGet(url, params, headers);
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:39:55/2018-12-07
	 * @desc 发送Post请求
	 * @param httpType 请求类型(httpClient,okHttp) 默认httpClient
	 * @param url      请求地址
	 * @param params   参数
	 * @param headers  请求头
	 * @return
	 */
	public static String sendRequestByPost(int httpType, String url, Map<String, String> params,
			Map<String, String> headers) {
		initHttpRequest(httpType);
		return doPost(url, params, headers);
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:31:13/2018-12-07
	 * @desc get请求
	 * @param url     请求地址
	 * @param params  参数
	 * @param headers 请求头
	 * @return
	 */
	private static String doGet(String url, Map<String, String> params, Map<String, String> headers) {
		if (Objects.isNull(params) && Objects.isNull(headers)) {
			return httpRequest.doGet(url);
		} else if (Objects.nonNull(params) && Objects.isNull(headers)) {
			return httpRequest.doGet(url, params);
		} else if (Objects.nonNull(params) && Objects.nonNull(headers)) {
			return httpRequest.doGet(url, params, headers);
		}
		return null;
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:31:37/2018-12-07
	 * @desc post请求
	 * @param url     请求地址
	 * @param params  参数
	 * @param headers 请求头
	 * @return
	 */
	private static String doPost(String url, Map<String, String> params, Map<String, String> headers) {
		if (Objects.isNull(params) && Objects.isNull(headers)) {
			return httpRequest.doPost(url);
		} else if (Objects.nonNull(params) && Objects.isNull(headers)) {
			return httpRequest.doPost(url, params);
		} else if (Objects.nonNull(params) && Objects.nonNull(headers)) {
			return httpRequest.doPost(url, params, headers);
		}
		return null;
	}

	/**
	 * @file HttpRequestFactory.java
	 * @author 番薯(Koali)
	 * @time 17:05:26/2018-12-07
	 * @desc 初始化httpRequest
	 * @param httpType
	 */
	private static void initHttpRequest(int httpType) {
		LOGGER.debug("[class: HttpRequestFactory.java]-[method: initHttpRequest]-[function: {}]-[params: httpType {}]",
				"初始化httpRequest", httpType);
		if (0 == httpType) {
			httpRequest = new HttpClientRequestImpl();
		} else {
			switch (httpType) {
			case HttpRequestConstant.HTTP_REQUEST_CLIENT:
				httpRequest = new HttpClientRequestImpl();
				break;
			default:
				break;
			}
		}
	}

}
