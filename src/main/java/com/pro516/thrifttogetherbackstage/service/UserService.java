package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.User;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:36
 */
public interface UserService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    Map<String, String> login(String username, String password);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);
}
