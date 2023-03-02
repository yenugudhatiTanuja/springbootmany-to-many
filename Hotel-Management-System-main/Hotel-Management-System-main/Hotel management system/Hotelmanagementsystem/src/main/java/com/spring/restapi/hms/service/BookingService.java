package com.spring.restapi.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.hms.model.Booking;
import com.spring.restapi.hms.repository.BookingRepository;

@Service
public class BookingService {
@Autowired
public BookingRepository bookingrepository;

public List<Booking> getBooking() {
	return   bookingrepository.findAll();	
}
public Booking getBooking(Integer booking_id) {
	return  bookingrepository.findById(booking_id).orElseThrow(null);
}
public Booking addBooking(Booking booking){
	 return  bookingrepository.save(booking);
}
public   Booking updateBooking(Booking booking) {
	return   bookingrepository.save(booking);
}
public void deleteById(int booking_id) {
	// TODO Auto-generated method stub
	bookingrepository.deleteById(booking_id);
}
}
