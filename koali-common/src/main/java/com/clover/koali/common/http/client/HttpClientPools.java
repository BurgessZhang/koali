package com.clover.koali.common.http.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project koali-common
 * @package com.clover.koali.common.http.client
 * @file HttpClientPools.java
 * @author 番薯(Koali)
 * @time 13:46:14/2018-12-07
 * @desc HttpClient 连接池
 */
public class HttpClientPools {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientPools.class);

	private static PoolingHttpClientConnectionManager httpClientConnectionManager = null;
	private static LaxRedirectStrategy redirectStrategy = null;
	private static HttpRequestRetryHandler myRequestRetryHandler = null;
	private static SSLConnectionSocketFactory sslConnectionSocketFactory = null;

	// 私有化构造方法
	private HttpClientPools() {
	}

	static {
		initHttpClient();
		// 启动清理连接池连接线程
		Thread idleConnectionMonitorThread = new IdleConnectionMonitorThread(httpClientConnectionManager);
		idleConnectionMonitorThread.setDaemon(true);
		idleConnectionMonitorThread.start();
	}

	/**
	 * @file HttpClientPools.java
	 * @author 番薯(Koali)
	 * @time 13:55:18/2018-12-07
	 * @desc 初始化HttpClient连接池
	 */
	public static void initHttpClient() {
		try {
			// 重定向策略初始化
			redirectStrategy = new LaxRedirectStrategy();
			// 请求重试机制，默认重试3次
			myRequestRetryHandler = new HttpRequestRetryHandler() {
				public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
					if (executionCount >= 3) {
						return false;
					}
					if (exception instanceof InterruptedIOException) {
						return false;
					}
					if (exception instanceof UnknownHostException) {
						return false;
					}
					if (exception instanceof ConnectTimeoutException) {
						return false;
					}
					if (exception instanceof SSLException) {
						// SSL handshake exception
						return false;
					}
					HttpClientContext clientContext = HttpClientContext.adapt(context);
					HttpRequest request = clientContext.getRequest();
					boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
					if (idempotent) {
						// Retry if the request is considered idempotent
						return true;
					}
					return false;
				}
			};
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(), NoopHostnameVerifier.INSTANCE);
			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", new PlainConnectionSocketFactory())//
					.register("https", sslConnectionSocketFactory)//
					.build();
			// 创建httpclient连接池
			httpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
			// 设置连接池最大数量,这个参数表示所有连接最大数。
			httpClientConnectionManager.setMaxTotal(200);
			// 设置单个路由最大连接数量，表示单个域名的最大连接数，
			// 例如:www.baidu.com.www.google.com表示不同的域名,则连接统一域名下的资源的最大连接数就是该参数,总和是上面的参数。
			httpClientConnectionManager.setDefaultMaxPerRoute(100);
		} catch (Exception e) {
			LOGGER.error("[class: HttpClientPools.java]-[method: initHttpClient]-[function: {}]-[params: ]-[结果: {}]",
					"初始化httpclient连接池失败....", e.getMessage());
		}
	}

	/**
	 * @file HttpClientPools.java
	 * @author 番薯(Koali)
	 * @time 14:14:19/2018-12-07
	 * @desc 获取httpClient实例
	 * @return
	 */
	public static CloseableHttpClient getHttpClient() {
		RequestConfig requestConfig = RequestConfig.custom()//
				.setConnectTimeout(3000)//
				.setSocketTimeout(3000)//
				// 忽略cookie,如果不需要登陆最好去掉,否则修改策略保存cookie即可
				.setCookieSpec(CookieSpecs.IGNORE_COOKIES)//
				.setConnectionRequestTimeout(6000)//
				// .setProxy(ip)//设置代理ip,不设置就用本机
				.build();
		// 连接池配置
		CloseableHttpClient httpClient = HttpClients.custom()//
				.setSSLSocketFactory(sslConnectionSocketFactory)//
				.setConnectionManager(httpClientConnectionManager)//
				.setDefaultRequestConfig(requestConfig)//
				.setRedirectStrategy(redirectStrategy)//
				.setRetryHandler(myRequestRetryHandler)//
				.build();

		return httpClient;
	}

	/**
	 * @file HttpClientPools.java
	 * @author 番薯(Koali)
	 * @time 14:19:08/2018-12-07
	 * @desc 校验IP
	 * @param ip
	 * @return
	 */
	public static boolean checkIp(HttpHost ip) {
		HttpResponse response;
		int code = 0;
		try {
			String url = "https://www.baidu.com";
			HttpClient hc = HttpClients.custom()//
					.setProxy(ip)//
					.build();
			HttpGet httpGet = new HttpGet(url);
			response = hc.execute(httpGet);
			code = response.getStatusLine().getStatusCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code == 200;
	}

	/**
	 * @file HttpClientPools.java
	 * @author 番薯(Koali)
	 * @time 14:21:39/2018-12-07
	 * @desc 设置请求头
	 * @param request
	 */
	public static void setCommonHeaders(AbstractHttpMessage request) {
		request.addHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		// request.addHeader("Connection", "keep-alive");
		request.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		request.addHeader("Accept-Encoding", "gzip, deflate, br");
		// User-Agent最好随机换
		request.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
	}

}
