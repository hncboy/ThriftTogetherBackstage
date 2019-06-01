package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 19:33
 */
public interface SearchService {

    /**
     * 根据城市id，用户id和返回记录数查询搜索记录
     *
     * @param cityId
     * @param userId
     * @param recordNum
     * @return
     */
    List<String> listUserSearchRecords(Integer cityId, Integer userId, Integer recordNum);

    /**
     * 根据城市id和关键字搜索店铺
     *
     * @param cityId
     * @param userId
     * @param keyword
     * @param start
     * @param size
     * @return
     */
    List<SimpleShopVO> searchShops(Integer cityId, Integer userId, String keyword, Integer start, Integer size);
}
