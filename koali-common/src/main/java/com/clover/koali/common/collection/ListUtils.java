package com.clover.koali.common.collection;

import java.util.List;
import java.util.Objects;

/**
 * @project koali-common
 * @package com.clover.koali.common.collection
 * @file ListUtils.java
 * @author 番薯(Koali)
 * @time 10:29:39/2018-12-10
 * @desc list集合操作
 */
public class ListUtils {
	
	
	//私有化构造方法
	private ListUtils() {}
	
	/**
	 * @file ListUtils.java
	 * @method isBlank
	 * @author 番薯(Koali)
	 * @time 10:31:16/2018-12-10
	 * @desc list集合为null或长度为0
	 * @param list
	 * @return
	 */
	public static boolean isBlank(List<?> list) {
		if (Objects.isNull(list) || list.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @file ListUtils.java
	 * @method isNotBlank
	 * @author 番薯(Koali)
	 * @time 10:34:29/2018-12-10
	 * @desc list集合不为null and 长度不为0
	 * @param list
	 * @return
	 */
	public static boolean isNotBlank(List<?> list) {
		return !isBlank(list);
	}

}
