package com.pro516.thrifttogetherbackstage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 19:29
 */
@Mapper
@Component
public interface SearchMapper {

    /**
     * 根据用户id和返回记录数查询搜索记录
     *
     * @param userId
     * @param recordNum
     * @return
     */
    List<String> listSearchRecordsByUserId(@Param("cityId") Integer cityId,
                                           @Param("userId") Integer userId,
                                           @Param("recordNum") Integer recordNum);

    /**
     * 根据城市id查找热门搜索记录
     *
     * @param cityId
     * @return
     */
    List<String> listHotSearchRecords(@Param("cityId") Integer cityId,
                                      @Param("recordNum") Integer recordNum);

    /**
     * 插入用户搜索记录
     *
     * @param map
     */
    void insertSearchRecord(Map<String, Object> map);
}
