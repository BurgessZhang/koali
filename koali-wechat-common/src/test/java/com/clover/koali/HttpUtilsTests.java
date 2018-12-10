package com.clover.koali;

import com.clover.koali.wechat.common.http.HttpUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali
 * @file HttpUtilsTests.java
 * @time 13:34/2018-12-10
 * @desc http请求测试
 */
public class HttpUtilsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtilsTests.class);

    @Test
    public void doGet(){
        String result = HttpUtils.doGet("http://www.baidu.com");
        System.out.println("返回值: " + result);
    }


}
