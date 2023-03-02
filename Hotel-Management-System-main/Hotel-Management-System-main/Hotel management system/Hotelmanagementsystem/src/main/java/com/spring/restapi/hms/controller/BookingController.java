package com.spring.restapi.hms.controller;
import com.spring.restapi.hms.model.Customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.hms.model.Booking;
import com.spring.restapi.hms.service.BookingService;
import com.spring.restapi.hms.service.CustomerService;
@RequestMapping("booking")
@RestController
public class BookingController {
	@Autowired
	public BookingService  bookingservice;
	@Autowired
	public CustomerService customerservice;
	
	@GetMapping("/bookings")
	public List<Booking> getBooking(){
		return this.bookingservice.getBooking();
	}
	@GetMapping("/booking/{booking_id}")
	public  Booking getBooking(@PathVariable Integer booking_id) {
		return  bookingservice.getBooking(booking_id);
	}
	
	@PostMapping("/addbooking1")
	public String addBooking1(@RequestBody Booking booking,@RequestParam ("cId")Integer cId)
	{
		Customer c=this.customerservice.searchById(cId);
	     booking.setCtr(c);
	     this.bookingservice.addBooking(booking);
		return "booking added has been successfully";	
	}
	
	/*@PostMapping("/addbooking")
	 public  Booking addBooking(@RequestBody Booking booking) {
		 return this.bookingservice.addBooking(booking);
	 }*/
	@PutMapping("/updatebooking/{booking_id}")
	public  Booking updateBooing(@RequestBody Booking booking, @PathVariable Integer booking_id) {
		booking.setBookingId(booking_id);
		return this. bookingservice.updateBooking(booking);
	}
	@DeleteMapping("/deletebooking/{booking_id}")
	public void deleteById(@PathVariable Integer  booking_id) {
	 bookingservice.deleteById( booking_id);
	}
}
