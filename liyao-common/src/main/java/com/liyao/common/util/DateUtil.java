package com.liyao.common.util;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Date 工具类
 *
 * @author Daidai
 */
public class DateUtil {

    /**
     * yyyy-MM-dd
     */
    public static String yyyy_MM_dd_EN = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm
     */
    public static String yyyy_MM_dd_HH_mm_EN = "yyyy-MM-dd HH:mm";

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String yyyy_MM_dd_HH_mm_ss_EN = "yyyy/MM/dd HH:mm";

    /**
     * yyyyMMdd
     */
    public static String yyyyMMdd = "yyyyMMdd";

    /**
     * HH:mm
     */
    public static String HH_mm = "HH:mm";

    /**
     * MM.dd
     */
    public static String MM_dd = "MM.dd";

    /**
     * yyyy年MM月dd日
     */
    public static String yyyy_MM_dd_CN = "yyyy年MM月dd日";

    /**
     * yyyy年MM月dd日HH时mm分
     */
    public static String yyyy_MM_dd_HH_mm_CN = "yyyy年MM月dd日HH时mm分";

    /**
     * yyyy年MM月dd日HH时mm分ss秒
     */
    public static String yyyy_MM_dd_HH_mm_ss_CN = "yyyy年MM月dd日HH时mm分ss秒";

    /**
     * yyyyMMddHHmmss
     */
    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * yyyy.MMdd.HHmmss
     */
    public static String yyyy_MMdd_HHmmss = "yyyy.MMdd.HHmmss";

    /**
     * 2015/04/15 05:03
     */
    public static String yyyy_MM_dd_HH_mm = "yyyy/MM/dd HH";

    public static String yyyy_MM_dd_HH_mm1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化函数
     *
     * @param date      格式化对象
     * @param strFormat 日期的格式化字符串
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String strFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        return sdf.format(date);
    }

    /**
     * 格式化当前日期为指定格式
     *
     * @param pattern 日期格式
     * @return 格式化后的日期字符串
     */
    public static String formatTo(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }


    /**
     * 为指定的日期增减若干分钟
     *
     * @param date   增减的日期对象
     * @param minute 增减的分钟数
     * @return 增减以后的日期
     */
    public static Date addMinute(Date date, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);

        return cal.getTime();
    }

    /**
     * 为指定的日期增减若干天
     *
     * @param date 增减的日期对象
     * @param day  增减的天数
     * @return 增减以后的日期
     */
    public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);

        return cal.getTime();
    }

    /**
     * 获得某天是周几
     *
     * @param date 日期
     * @return 周几（数字）
     */
    public static int getWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获得某天是几号
     *
     * @param date 日期
     * @return 几号（数字）
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 为指定的日期增减若干年
     *
     * @param date
     * @param year
     * @return
     */
    public static Date addYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);

        return cal.getTime();
    }


    public static void getTimeByCalendar() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH);//获取月份
        int day = cal.get(Calendar.DATE);//获取日
        int hour = cal.get(Calendar.HOUR);//小时
        int minute = cal.get(Calendar.MINUTE);//分           
        int second = cal.get(Calendar.SECOND);//秒
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        System.out.println("现在的时间是：公元" + year + "年" + month + "月" + day + "日      " + hour + "时" + minute + "分" + second + "秒       星期" + WeekOfYear);
    }

    public static String getNowYearMonthDayStr() {
        return getNowYearMonthDayStr(new Date());
    }

    public static String getNowYearMonthDayStr(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH) + 1;//获取月份
        int day = cal.get(Calendar.DATE);//获取日

        return year + "" + String.format("%02d", month) + String.format("%02d", day);
    }


    public static Date add(Date now, Integer day) {
        Instant instant = now.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return add(localDateTime, day);
    }

    public static Date add(LocalDateTime dateTime, Integer day) {
        dateTime = dateTime.plusDays(day.longValue());
        ZoneId zone = ZoneId.systemDefault();
        return Date.from(dateTime.atZone(zone).toInstant());
    }

    public static Long getToLaseTime() {
        Calendar t = Calendar.getInstance();
        Long now = t.getTimeInMillis();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR_OF_DAY, 0);
        t.set(Calendar.MINUTE, 0);
        t.set(Calendar.SECOND, 0);
        Long die = t.getTimeInMillis();
        return (die - now) / 1000;
    }

    //判断某一时间是否在限定时间内
    public static int compareStartAndEnd(Date startTime, Date endTime) {
        Date now = new Date();
        if (startTime.after(now)) {
            return 0;
        }
        if (endTime.before(now)) {
            return 1;
        }
        return 2;
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern)
            throws Exception {

        return strDate == null || strDate.length() == 0 ? null : new SimpleDateFormat(
                pattern).parse(strDate);
    }

    public static Date getFirstDateAtMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //当月一号
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        System.out.println("本月第一天: " + sdf.format(calendar.getTime()));
        return time;
    }
}
