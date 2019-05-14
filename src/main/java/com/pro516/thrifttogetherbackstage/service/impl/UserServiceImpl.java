package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
import com.pro516.thrifttogetherbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-13
 * Time: 14:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, String> login(String username, String password) {
        Map<String, String> loginInfo = new HashMap<>();
        String userId = String.valueOf(userMapper.getUserId(username, password));
        if (!"null".equals(userId)) {
            loginInfo.put("status", "success");
            loginInfo.put("userId", String.valueOf(userMapper.getUserId(username, password)));
            return loginInfo;
        }
        loginInfo.put("status", "failure");
        loginInfo.put("failInfo", "手机号或密码错误");
        return loginInfo;
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.findUserByUserId(userId);
    }
}
