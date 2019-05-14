package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


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
}
