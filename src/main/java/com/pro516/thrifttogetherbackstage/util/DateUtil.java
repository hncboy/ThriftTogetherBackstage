package com.pro516.thrifttogetherbackstage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 10:12
 */
public class DateUtil {

    /**
     * 格式化日期 yyyy-MM-dd
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return simpleDateFormat.format(date);
    }
}
