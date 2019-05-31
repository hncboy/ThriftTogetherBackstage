package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
import com.pro516.thrifttogetherbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private ShopMapper shopMapper;

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

    @Transactional
    @Override
    public void updateUserAvator(Integer userId, String avatorUrl) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("avatorUrl", avatorUrl);
        userMapper.updateUserAvator(map);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listUserRecentlyBrowseShops(Integer userId) {
        List<Integer> shopIds = userMapper.listUserRecentlyBrowseShops(userId);
        List<SimpleShopVO> simpleShopVOList = new ArrayList<>();
        for (Integer shopId: shopIds) {
            SimpleShopVO simpleShopVO = shopMapper.getSimpleShopByShopId(shopId);
            simpleShopVOList.add(simpleShopVO);
        }
        return simpleShopVOList;
    }

    @Transactional
    @Override
    public void userFeedback(Integer userId, String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("content", content);
        userMapper.insertOpinion(map);
    }
}
