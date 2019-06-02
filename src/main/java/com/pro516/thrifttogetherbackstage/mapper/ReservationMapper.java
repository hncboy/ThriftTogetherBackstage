package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Reservation;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReservationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 9:57
 */
@Mapper
@Component
public interface ReservationMapper {

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
    void cancelReservation(@Param("reservationId") Integer reservationId);

    /**
     * 根据用户id和预定状态查询预约信息
     *
     * @param userId
     * @param reservationStatus
     * @return
     */
    List<SimpleReservationVO> listSimpleReservations(@Param("userId") Integer userId,
                                                   @Param("reservationStatus") Integer reservationStatus);
}
