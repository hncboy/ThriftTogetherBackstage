package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Reservation;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReservationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 9:58
 */
public interface ReservationService {

    /**
     * 添加预约
     *
     * @param reservation
     */
    void insertReservation(@Param("reservation") Reservation reservation);

    /**
     * 取消预约
     *
     * @param reservationId
     */
    void cancelReservation(Integer reservationId);

    /**
     * 根据用户id查询预约信息
     *
     * @param userId
     * @return
     */
    List<SimpleReservationVO> listSimpleReservationsByUserId(Integer userId);
}
