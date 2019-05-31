package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
    Result login(String username, String password);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);

    /**
     * 注册用户
     *
     * @param user
     */
    void register(User user);

    /**
     * 发送短信验证码
     *
     * @param phone
     */
    void createSmsCode(String phone);

    /**
     * 校验验证码
     *
     * @param phone
     * @param code
     * @return
     */
    boolean checkSmsCode(String phone, String code);

    /**
     * 更新用户头像
     *
     * @param userId
     * @param avatorUrl
     */
    void updateUserAvator(Integer userId, String avatorUrl);

    /**
     * 根据用户id获取用户最近浏览店铺记录
     *
     * @param userId
     * @return
     */
    List<SimpleShopVO> listUserRecentlyBrowseShops(@Param("userId") Integer userId);
}
