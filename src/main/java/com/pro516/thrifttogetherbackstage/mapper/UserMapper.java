package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.entity.vo.CollectedShopVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:19
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 根据手机号和密码获取用户id
     *
     * @param phone
     * @param password
     * @return
     */
    Integer getUserId(@Param("phone") String phone, @Param("password") String password);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);

    /**
     * 添加用户
     *
     * @param user
     */
    void add(User user);

    void updateUserAvator(Map<String, Object> map);

    /**
     * 根据用户id获取用户最近浏览店铺id
     *
     * @param userId
     * @return
     */
    List<Integer> listUserRecentlyBrowseShops(@Param("userId") Integer userId);

    /**
     * 插入一条用户的浏览店铺记录
     *
     * @param userId
     * @param shopId
     */
    void insertRecentlyBrowseShop(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    /**
     * 插入用户的反馈意见
     *
     * @param map
     * @return
     */
    void insertOpinion(Map<String, Object> map);
}
