package com.clover.koali.common.http.client;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project koali-common
 * @package com.clover.koali.common.http.client
 * @file IdleConnectionMonitorThread.java
 * @author 番薯(Koali)
 * @time 13:51:30/2018-12-07
 * @desc 释放连接池
 */
public class IdleConnectionMonitorThread extends Thread {

	private static final Logger LOGGER = LoggerFactory.getLogger(IdleConnectionMonitorThread.class);

	public static final long RELEASE_CONNECTION_WAIT_TIME = 5000;// 监控连接间隔
	private static volatile boolean shutdown = false;
	private PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;

	public IdleConnectionMonitorThread(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
		this.poolingHttpClientConnectionManager = poolingHttpClientConnectionManager;
	}

	@Override
	public void run() {
		try {
			while (!shutdown) {
				synchronized (IdleConnectionMonitorThread.class) {
					wait(RELEASE_CONNECTION_WAIT_TIME);
					// Close expired connections
					poolingHttpClientConnectionManager.closeExpiredConnections();
					// that have been idle longer than 30 sec
					poolingHttpClientConnectionManager.closeIdleConnections(2, TimeUnit.MINUTES);
				}
			}
		} catch (InterruptedException ex) {
			LOGGER.error("[class: IdleConnectionMonitorThread.java]-[method: run]-[function: {}]-[params: ]-[结果: {}]",
					"释放连接池连接出错.", ex.getMessage());
		}
	}

	public void shutdown() {
		shutdown = true;
		synchronized (IdleConnectionMonitorThread.class) {
			notifyAll();
		}
	}

}
