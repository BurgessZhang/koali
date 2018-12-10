package com.clover.koali.common.http.client;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clover.koali.common.util.StringUtils;

/**
 * @project koali-common
 * @package com.clover.koali.common.http.client
 * @file HttpClientUtils.java
 * @author 番薯(Koali)
 * @time 14:34:14/2018-12-07
 * @desc httpClient请求
 */
public class HttpClientUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

	private static MyResponseHandler responseHandler = new MyResponseHandler();

	/**
	 * @file HttpClientUtils.java
	 * @author 番薯(Koali)
	 * @time 14:37:09/2018-12-07
	 * @desc get请求
	 * @param urlString 请求的URL地址与参数
	 * @param headerMap 请求头
	 * @return
	 */
	public static String getUrlContent(String urlString, Map<String, String> headerMap) {

		if (StringUtils.isBlank(urlString) || !urlString.startsWith("http")) {
			LOGGER.error(
					"[class: HttpClientUtils.java]-[method: getUrlContent]-[function: {}]-[params: urlString, headerMap]-[结果: {}]",
					"get请求", "http url 为null");
			return null;
		}

		HttpGet httpGet = null;
		// 转化String url为URI,解决url中包含特殊字符的情况
		try {
			URL url = new URL(urlString.trim());
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			httpGet = new HttpGet(uri);
			HttpClientPools.setCommonHeaders(httpGet);
			// 当headerMap 不为Null时，设置请求头
			if (Objects.nonNull(headerMap) && !headerMap.isEmpty()) {
				for (Map.Entry<String, String> header : headerMap.entrySet()) {
					if (httpGet.containsHeader(header.getKey())) {
						httpGet.setHeader(header.getKey(), header.getValue());
					} else {
						httpGet.addHeader(header.getKey(), header.getValue());
					}
				}
			}
			HttpClient httpClient = HttpClientPools.getHttpClient();
			String result = httpClient.execute(httpGet, responseHandler);
			LOGGER.debug(
					"[class: HttpClientUtils.java]-[method: getUrlContent]-[function: {}]-[params: urlString, headerMap {}]",
					"get请求 返回值: ", result);
			return result;
		} catch (Exception e) {
			LOGGER.error(
					"[class: HttpClientUtils.java]-[method: getUrlContent]-[function: {}]-[params: urlString, headers]-[结果: {}]",
					"get请求错误", e.getMessage());
			return null;
		} finally {
			httpGet.abort();
		}
	}

	/**
	 * @file HttpClientUtils.java
	 * @author 番薯(Koali)
	 * @time 14:38:14/2018-12-07
	 * @desc post请求
	 * @param urlString 请求地址
	 * @param params    参数
	 * @param headerMap 请求头
	 * @return
	 */
	public static String postForEntity(String urlString, Map<String, String> params, Map<String, String> headerMap) {

		// 参数设置
		if (StringUtils.isBlank(urlString) || !urlString.startsWith("http")) {
			LOGGER.error(
					"[class: HttpClientUtils.java]-[method: postForEntity]-[function: {}]-[params: urlString, params, headerMap]-[结果: {}]",
					"post 请求", "http url is null");
			return null;
		}
		HttpPost httpPost = null;
		try {
			URL url = new URL(urlString.trim());
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
			httpPost = new HttpPost(uri);
			HttpClientPools.setCommonHeaders(httpPost);
			// 当headerMap 不为Null时，设置请求头
			if (Objects.nonNull(headerMap) && !headerMap.isEmpty()) {
				for (Map.Entry<String, String> header : headerMap.entrySet()) {
					if (httpPost.containsHeader(header.getKey())) {
						httpPost.setHeader(header.getKey(), header.getValue());
					} else {
						httpPost.addHeader(header.getKey(), header.getValue());
					}
				}
			}
			if (params != null && params.size() > 0) {
				List<BasicNameValuePair> nvps = new ArrayList<>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				// 这里设置的是返回结果编码,大多数都是UTF-8,如果乱码,可以查看网页的meta中的content的编码.如果是GBK,这里改为GBK即可.
				// 这里entity只能读取一次
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			}
			HttpClient httpClient = HttpClientPools.getHttpClient();
			String result = httpClient.execute(httpPost, responseHandler);
			LOGGER.debug(
					"[class: HttpClientUtils.java]-[method: postForEntity]-[function: {}]-[params: urlString, params, headerMap {}]",
					"post请求返回值", result);
			return result;
		} catch (Exception e) {
			LOGGER.error(
					"[class: HttpClientUtils.java]-[method: postForEntity]-[function: {}]-[params: urlString, params, headers]-[结果: {}]",
					"post请求错误", e.getMessage());
			return null;
		} finally {
			httpPost.abort();
		}
	}

}
