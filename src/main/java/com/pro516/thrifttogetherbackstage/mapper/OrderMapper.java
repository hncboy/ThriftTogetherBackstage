package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:28
 */
@Mapper
@Component
public interface OrderMapper {

    /**
     * 根据订单状态获取订单，按时间降序
     *
     * @param orderStatus
     * @return
     */
    List<SimpleOrderVO> listOrdersByStatus(@Param("userId") Integer userId,
                                           @Param("orderStatus") Integer orderStatus);
}
