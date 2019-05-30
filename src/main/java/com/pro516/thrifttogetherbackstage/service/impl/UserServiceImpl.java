package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
import com.pro516.thrifttogetherbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static com.pro516.thrifttogetherbackstage.enums.ResultCode.USER_LOGIN_ERROR;

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

    @Transactional(readOnly = true)
    @Override
    public Result login(String username, String password) {
        String userId = String.valueOf(userMapper.getUserId(username, password));
        if (!"null".equals(userId)) {
            return Result.success(findUserByUserId(userMapper.getUserId(username, password)));
        }
        return Result.failure(USER_LOGIN_ERROR);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public void register(User user) {

    }

    @Override
    public void createSmsCode(String phone) {

    }

    @Override
    public boolean checkSmsCode(String phone, String code) {
        return false;
    }
}
