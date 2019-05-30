package com.pro516.thrifttogetherbackstage.util;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-06
 * Time: 19:31
 */
public class RandomUtil {

    /**
     * 生成一个32位的订单号
     * @return
     */
    public static String createOrderUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
