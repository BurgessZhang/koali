package com.clover.koali.common.collection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @project koali-common
 * @package com.clover.koali.common.collection
 * @file MapUtils.java
 * @author 番薯(Koali)
 * @time 10:36:36/2018-12-10
 * @desc map操作工具类
 */
public class MapUtils {

	// 私有化构造方法
	private MapUtils() {
	}

	/**
	 * @file MapUtils.java
	 * @method isBlank
	 * @author 番薯(Koali)
	 * @time 10:37:59/2018-12-10
	 * @desc map为Null或size为0
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isBlank(Map<K, V> map) {
		if (Objects.isNull(map) || map.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * @file MapUtils.java
	 * @method isNotBlank
	 * @author 番薯(Koali)
	 * @time 10:39:18/2018-12-10
	 * @desc map不为null and size != 0
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isNotBlank(Map<K, V> map) {

		return !isBlank(map);
	}

	/**
	 * @file MapUtils.java
	 * @method beanToMap
	 * @author 番薯(Koali)
	 * @time 10:46:05/2018-12-10
	 * @desc 将bean转换为map
	 * @param object
	 * @param clazz
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> beanToMap(Object object, Class<?> clazz)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> map = new HashMap<>();
		// 获取指定类的beaninfo对象
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
		// 获取所有的属性描述器
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		String key = null;
		Method method = null;
		Object value = null;
		for (PropertyDescriptor pDescriptor : propertyDescriptors) {
			key = pDescriptor.getName();
			method = pDescriptor.getReadMethod();
			value = method.invoke(object);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * @file MapUtils.java
	 * @method mapToBean
	 * @author 番薯(Koali)
	 * @time 10:51:10/2018-12-10
	 * @desc 将map转换为bean
	 * @param map
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> T mapToBean(Map<String, Object>map,Class<T> clazz) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		//创建bean对象
		T object = clazz.newInstance();
		//获取指定类的beanInfo对象
		BeanInfo beanInfo = Introspector.getBeanInfo(clazz,Object.class);
		//获取所有的属性描述器
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Object value = map.get(propertyDescriptor.getName());
			Method method = propertyDescriptor.getWriteMethod();
			
			method.invoke(object, value);
		}
		return object;
	}
}
