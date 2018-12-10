package com.clover.koali.common.date;

/**
 * @project koali-common
 * @package com.clover.koali.common.date
 * @file DateFormatEnum.java
 * @author 番薯(Koali)
 * @time 17:49:49/2018-12-07
 * @desc 日期格式枚举
 */
public enum DateFormatEnum {

	DATE_FORMAT_YM("yyyy-MM"),
	DATE_FORMAT_YMD("yyyy-MM-dd"),
	DATE_FORMAT_YMDH("yyyy-MM-dd HH"),
	DATE_FORMAT_YMDHM("yyyy-MM-dd HH:mm"),
	DATE_FORMAT_YMDHMS("yyyy-MM-dd HH:mm:ss"),
	DATE_FORMAT_PATTERN_YM("yyyy/MM"),
	DATE_FORMAT_PATTERN_YMD("yyyy/MM/dd"),
	DATE_FORMAT_PATTERN_YMDH("yyyy/MM/dd HH"),
	DATE_FORMAT_PATTERN_YMDHM("yyyy/MM/dd HH:mm"),
	DATE_FORMAT_PATTERN_YMDHMS("yyyy/MM/dd HH:mm:ss"),
	DATE_FORMAT_ZH_PATTERN_YMDH("yyyy年MM月dd HH"),
	DATE_FORMAT_ZH_PATTERN_YMDHM("yyyy年MM月dd HH:mm"),
	DATE_FORMAT_ZH_PATTERN_YMDHMS("yyyy年MM月dd HH:mm:ss"),
	DATE_FORMAT_ZH_YM("yyyy年MM月"),
	DATE_FORMAT_ZH_YMD("yyyy年MM月dd"),
	DATE_FORMAT_ZH_YMDH("yyyy年MM月dd HH时"),
	DATE_FORMAT_ZH_YMDHM("yyyy年MM月dd HH时mm分"),
	DATE_FORMAT_ZH_YMDHMS("yyyy年MM月dd HH时mm分ss");
	
	private String value;
	
	private DateFormatEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
