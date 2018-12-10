package com.clover.koali.wechat.common.http;

import com.clover.koali.common.http.HttpRequestConstant;
import com.clover.koali.common.http.HttpRequestFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.common.http
 * @file HttpUtils.java
 * @time 11:38/2018-12-10
 * @desc 微信http request工具类
 */
public class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);


    //私有化构造方法
    private HttpUtils(){}

    /**
     * @file HttpUtils.java
     * @method doGet
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 无参get请求
     * @params '[url]
     * @result java.lang.String
     */
    public static String doGet(String url){
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","无参get请求",url);

        String result = HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_GET,url,null,null);
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","无参get请求",url,result);

        return  result;
    }

    /**
     * @file HttpUtils.java
     * @method doGet
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 有参数get请求
     * @params '[url, params]
     * @result java.lang.String
     */
    public static String doGet(String url,Map<String,String> params){
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","有参get请求",url,params);
        String result = HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_GET,url,params,null);
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","有参get请求",url,result);
        return result;
    }

    /**
     * @file HttpUtils.java
     * @method doGet
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 自定义请求头get请求
     * @params '[url, params, headers]
     * @result java.lang.String
     */
    public static String doGet(String url,Map<String,String> params,Map<String,String> headers){
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","自定义请求头get请求",url,params,headers);
        String result =  HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_GET,url,params,headers);
        LOGGER.debug("[class: HttpUtils.java]-[method: doGet]-[function: {}]-[参数/结果]: {}","自定义请求头get请求",url,result);
        return result;
    }

    /**
     * @file HttpUtils.java
     * @method doPost
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 无参数post请求
     * @params '[url]
     * @result java.lang.String
     */
    public static String doPost(String url){
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","无参POST请求",url);
        String result = HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_POST,url,null,null);
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","无参数post请求",url,result);
        return result;
    }


    /**
     * @file HttpUtils.java
     * @method doPost
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 有参post请求
     * @params '[url, params]
     * @result java.lang.String
     */
    public static String doPost(String url,Map<String,String> params){
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","有参post请求",url,params);
        String result = HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_POST,url,params,null);
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","有参post请求",url,result);
        return  result;
    }

    /**
     * @file HttpUtils.java
     * @method doPost
     * @author 番薯(Koali)
     * @time /2018/12/10/010
     * @desc 自定义header的post请求
     * @params '[url, params, headers]
     * @result java.lang.String
     */
    public static String doPost(String url,Map<String,String> params,Map<String,String> headers){
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","自定义header的post请求",url,params,headers);
        String result = HttpRequestFactory.sendReqeust(HttpRequestConstant.HTTP_REQUEST_CLIENT,HttpRequestConstant.HTTP_REQUEST_TYPE_POST,url,params,headers);
        LOGGER.debug("[class: HttpUtils.java]-[method: doPost]-[function: {}]-[参数/结果]: {}","自定义header的post请求",url,result);
        return result;
    }


}
