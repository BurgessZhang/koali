package com.clover.koali.wechat.miniapp.service;

import com.clover.koali.wechat.miniapp.bean.*;

import java.util.Date;
import java.util.List;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.service
 * @file WxMaAnalysisService.java
 * @time 14:48/2018-12-19
 * @desc 小程序数据分析相关接口
 */
public interface WechatMiniAnalysisService {

    String GET_DAILY_SUMMARY_TREND_URL = "https://api.weixin.qq.com/datacube/getweanalysisappiddailysummarytrend";
    String GET_DAILY_VISIT_TREND_URL = "https://api.weixin.qq.com/datacube/getweanalysisappiddailyvisittrend";
    String GET_WEEKLY_VISIT_TREND_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidweeklyvisittrend";
    String GET_MONTHLY_VISIT_TREND_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyvisittrend";
    String GET_VISIT_DISTRIBUTION_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidvisitdistribution";
    String GET_DAILY_RETAIN_INFO_URL = "https://api.weixin.qq.com/datacube/getweanalysisappiddailyretaininfo";
    String GET_WEEKLY_RETAIN_INFO_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidweeklyretaininfo";
    String GET_MONTHLY_RETAIN_INFO_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyretaininfo";
    String GET_VISIT_PAGE_URL = "https://api.weixin.qq.com/datacube/getweanalysisappidvisitpage";
    String GET_USER_PORTRAIT_URL = "https://api.weixin.qq.com/datacube/getweanalysisappiduserportrait";

    /**
     * 查询概况趋势
     * 温馨提示：小程序接口目前只能查询一天的数据，即 beginDate 和 endDate 一样
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期，限定查询1天数据，end_date允许设置的最大值为昨日
     * @return 概况趋势
     */
    List<WechatMiniSummaryTrend> getDailySummaryTrend(Date beginDate, Date endDate);

    /**
     * 获取日访问趋势
     * 温馨提示：小程序接口目前只能查询一天的数据，即 beginDate 和 endDate 一样
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期，限定查询1天数据，end_date允许设置的最大值为昨日
     * @return 日访问趋势
     */
    List<WechatMiniVisitTrend> getDailyVisitTrend(Date beginDate, Date endDate);

    /**
     * 获取周访问趋势
     * 限定查询一个自然周的数据，时间必须按照自然周的方式输入： 如：20170306(周一), 20170312(周日)
     *
     * @param beginDate 开始日期，为周一日期
     * @param endDate   结束日期，为周日日期，限定查询一周数据
     * @return 周访问趋势（每项数据都是一个自然周汇总）
     */
    List<WechatMiniVisitTrend> getWeeklyVisitTrend(Date beginDate, Date endDate);

    /**
     * 获取月访问趋势
     * 限定查询一个自然月的数据，时间必须按照自然月的方式输入： 如：20170201(月初), 20170228(月末)
     *
     * @param beginDate 开始日期，为自然月第一天
     * @param endDate   结束日期，为自然月最后一天，限定查询一个月数据
     * @return 月访问趋势（每项数据都是一个自然月汇总）
     */
    List<WechatMiniVisitTrend> getMonthlyVisitTrend(Date beginDate, Date endDate);

    /**
     * 获取访问分布
     * （此接口目前只能查询一天的数据，即 beginDate 和 endDate 一样）
     *
     * @param beginDate 开始日期，为周一日期
     * @param endDate   结束日期，限定查询1天数据，end_date允许设置的最大值为昨日
     * @return 访问分布
     */
    WechatMiniVisitDistribution getVisitDistribution(Date beginDate, Date endDate);

    /**
     * 日留存
     * （此接口目前只能查询一天的数据，即 beginDate 和 endDate 一样）
     *
     * @param beginDate 开始日期，为周一日期
     * @param endDate   结束日期，限定查询 1 天数据，endDate 允许设置的最大值为昨日
     * @return 日留存
     */
    WechatMiniRetainInfo getDailyRetainInfo(Date beginDate, Date endDate);

    /**
     * 周留存
     * 限定查询一个自然周的数据，时间必须按照自然周的方式输入： 如：20170306(周一), 20170312(周日)
     *
     * @param beginDate 开始日期，为周一日期
     * @param endDate   结束日期，为周日日期，限定查询一周数据
     * @return 周留存
     */
    WechatMiniRetainInfo getWeeklyRetainInfo(Date beginDate, Date endDate);

    /**
     * 月留存
     * 限定查询一个自然月的数据，时间必须按照自然月的方式输入： 如：20170201(月初), 20170228(月末)
     *
     * @param beginDate 开始日期，为自然月第一天
     * @param endDate   结束日期，为自然月最后一天，限定查询一个月数据
     * @return 月留存
     */
    WechatMiniRetainInfo getMonthlyRetainInfo(Date beginDate, Date endDate);

    /**
     * 获取访问页面数据
     * 温馨提示：此接口目前只能查询一天的数据，即 beginDate 和 endDate 一样
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期，限定查询1天数据，end_date允许设置的最大值为昨日
     * @return 访问页面数据
     */
    List<WechatMiniVisitPage> getVisitPage(Date beginDate, Date endDate);

    /**
     * 获取小程序新增或活跃用户的画像分布数据
     * 时间范围支持昨天、最近7天、最近30天。
     * 其中，新增用户数为时间范围内首次访问小程序的去重用户数，
     * 活跃用户数为时间范围内访问过小程序的去重用户数。
     * 画像属性包括用户年龄、性别、省份、城市、终端类型、机型。
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期，开始日期与结束日期相差的天数限定为0/6/29，分别表示查询最近1/7/30天数据，end_date允许设置的最大值为昨日
     * @return 小程序新增或活跃用户的画像分布数据
     */
    WechatMiniUserPortrait getUserPortrait(Date beginDate, Date endDate);
}
