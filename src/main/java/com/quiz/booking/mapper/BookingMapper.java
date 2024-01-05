package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
	public void insertBooking(
			@Param("name") String name,
			@Param("date") String date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber
			);
	
	public int deleteBookingByid(int id);
	
	
	//in: 2개 파라미터     output: List<Booking>
	public List<Booking> selectBookingListByNP(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
