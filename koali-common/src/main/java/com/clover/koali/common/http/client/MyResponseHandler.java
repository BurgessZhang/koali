package com.clover.koali.common.http.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project koali-common
 * @package com.clover.koali.common.http.client
 * @file MyResponseHandler.java
 * @author 番薯(Koali)
 * @time 14:23:55/2018-12-07
 * @desc 响应处理类，返回处理结果
 */
public class MyResponseHandler implements ResponseHandler<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyResponseHandler.class);

	/**
	 * @file MyResponseHandler.java
	 * @author 番薯(Koali)
	 * @time 14:24:22/2018-12-07
	 * @desc 响应处理类，返回处理结果
	 * @param response
	 * @return String 响应结果
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @see org.apache.http.client.ResponseHandler#handleResponse(org.apache.http.HttpResponse)
	 */
	@Override
	public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		try {
			// 返回状态码
			int statusCode = response.getStatusLine().getStatusCode();
			switch (statusCode) {
			case 200:
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			case 400:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "400错误代码，请求出现语法错误.");
				break;
			case 403:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "403错误代码，资源不可用.");
				break;
			case 404:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "404错误代码，无法找到指定资源地址.");
				break;
			case 503:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "503错误代码，服务不可用.");
				break;
			case 504:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "504错误代码，网关超时.");
				break;
			default:
				LOGGER.error(
						"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
						"响应处理类，返回处理结果", "未处理的错误,code=" + statusCode);
			}

		} finally {
			if (response != null) {
				try {
					((CloseableHttpResponse) response).close();
				} catch (IOException e) {
					LOGGER.error(
							"[class: MyResponseHandler.java]-[method: handleResponse]-[function: {}]-[params: response]-[结果: {}]",
							"响应处理类，返回处理结果", e.getMessage());
				}
			}
		}
		return "";
	}

}
