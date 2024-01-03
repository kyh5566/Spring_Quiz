package com.quiz.booking.mapper;

import java.util.List;

import com.quiz.booking.domain.Booking;

public interface BookingMapper {
	
	public List<Booking> selectBookingList();
}
