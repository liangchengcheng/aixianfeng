package com.lcc.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lcc on 2017/1/13.
 */
public class DateFormatUtils {

    public static Long HOURS_LONG = 3600000L;

    /**
     * 获取时间年和月
     */
    public static String formatToYearMonth(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }

    /**
     * 取得日
     *
     * @param date 日期
     */
    public static String formatToDay(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(date);
    }

    /**
     * 取得小时
     */
    public static Integer formatToHour(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
        return Integer.valueOf(dateFormat.format(date));
    }

    /**
     * 字符串转日期格式(格式：yyyy-MM)
     *
     * @param dateStr 日期字符串
     */
    public static Date formatStrToYM(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.parse(dateStr);
    }

    /**
     * 为了时间类型增加月份
     */
    public static Date addMonth(String timeStamp, int number) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = simpleDateFormat.parse(timeStamp);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.MONTH, number);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断日期相减是否大于1小时
     */
    public static boolean isThanOneHour(Date minuendDate,Date subtrahendDate){
        Long minuendLong = minuendDate.getTime();
        Long subtrahendLong = subtrahendDate.getTime();

        Long result = minuendLong - subtrahendLong;
        if((result / HOURS_LONG) < 1){
            return false;
        }else{
            return true;
        }
    }


}
