package com.spring.restapi.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.hms.model.Admin;
import com.spring.restapi.hms.model.Hotel;
import com.spring.restapi.hms.service.AdminService;
import com.spring.restapi.hms.service.HotelService;

@RequestMapping("hotel")
@RestController

public class HotelController {
	@Autowired
	public HotelService hotelservice;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/hi")
	public String getMessage() {
		return "Welcome to our Hotel booking Platform";
	}

	@GetMapping("/hotels")
	public List<Hotel> getHotels() {
		return this.hotelservice.getHotels();
	}

	@GetMapping("/hotel/{hotel_id}")
	public Hotel getHotel(@PathVariable Integer hotel_id) {
		return hotelservice.getHotel(hotel_id);
	}
	/*@PostMapping("/addHotel")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return this.hotelservice.addHotel(hotel);
	}*/

	@PostMapping("/addhotel")
	public String addHotel(@RequestBody Hotel hotel,@RequestParam ("adminId")Integer adminId) 
	{
		Admin d = this.adminService.searchById(adminId);
		hotel.setAdm(d);  
		this.hotelservice.addHotel(hotel);
		return "Hotel added has been successfully";
	
	}
	
	@PutMapping("/update/{hotel_id}")
	public Hotel updateHotel(@RequestBody Hotel hotel,@PathVariable Integer hotel_id) {
		hotel.setHotelId(hotel_id);
		return this.hotelservice.updateHotel(hotel);
	}

	@DeleteMapping("/deletehotel/{hotel_id}")
	public void deleteById(@PathVariable Integer hotel_id) {
		hotelservice.deleteById(hotel_id);
	}
	
	@GetMapping("/hotelsort/{field}")
	public List<Hotel> getHotelSort(@PathVariable String field)
	{
		return this.hotelservice.getAllHotelWithSort(field);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Hotel>> viewHomePage(@Param("keyword") String keyword) {
		List<Hotel> body = hotelservice.listAll(keyword);
		return new ResponseEntity<List<Hotel>>(body, HttpStatus.OK);
	}
}