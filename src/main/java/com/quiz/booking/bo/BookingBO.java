package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	public void addBooking(String name, String date, int day,  int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name,date,day,headcount,phoneNumber);
	}
	public int deleteBookingByid(int id) {
		return bookingMapper.deleteBookingByid(id);
	}
	public Booking getBookingByNP(String name, String phoneNumber) {
		
		return bookingMapper.selectBookingByNP(name,phoneNumber);
	}
}
