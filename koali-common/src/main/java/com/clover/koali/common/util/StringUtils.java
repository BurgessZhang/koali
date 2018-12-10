package com.clover.koali.common.util;

/**
 * @project koali-common
 * @package com.clover.koali.common.util
 * @file StringUtils.java
 * @author 番薯(Koali)
 * @time 15:04:10/2018-12-07
 * @desc 字符串工具类
 */
public class StringUtils {

	/**
	 * @file StringUtils.java
	 * @author 番薯(Koali)
	 * @time 15:05:02/2018-12-07
	 * @desc 字符串为null
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str != null && (strLen = str.length()) != 0) {
			for (int i = 0; i < strLen; ++i) {
				if (!Character.isWhitespace(str.charAt(i))) {
					return false;
				}
			}

			return true;
		} else {
			return true;
		}
	}

	/**
	 * @file StringUtils.java
	 * @author 番薯(Koali)
	 * @time 15:05:34/2018-12-07
	 * @desc 字符串非null
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
}
