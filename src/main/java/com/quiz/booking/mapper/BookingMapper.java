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
	
	public List<Booking> selectBookingByNP(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
