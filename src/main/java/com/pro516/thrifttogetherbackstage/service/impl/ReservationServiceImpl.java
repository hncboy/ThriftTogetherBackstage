package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Reservation;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReservationVO;
import com.pro516.thrifttogetherbackstage.mapper.ReservationMapper;
import com.pro516.thrifttogetherbackstage.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/2
 * Time: 9:59
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public void insertReservation(Reservation reservation) {
        reservationMapper.insertReservation(reservation);
    }

    @Override
    public void cancelReservation(Integer reservationId) {
        reservationMapper.cancelReservation(reservationId);
    }

    @Override
    public List<SimpleReservationVO> listSimpleReservationsByUserId(Integer userId) {
        List<SimpleReservationVO> simpleReservationVOS = new ArrayList<>();
        simpleReservationVOS.addAll(reservationMapper.listSimpleReservations(userId, 0));
        simpleReservationVOS.addAll(reservationMapper.listSimpleReservations(userId, 1));
        // TODO 已过期预约没弄
        simpleReservationVOS.addAll(reservationMapper.listSimpleReservations(userId, 2));
        return simpleReservationVOS;
    }
}
