package com.spring.restapi.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.restapi.hms.model.Customer;
import com.spring.restapi.hms.model.Hotel;
import com.spring.restapi.hms.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	public HotelRepository hotelrepository;

	public List<Hotel> getHotels() {
		return hotelrepository.findAll();
	}

	public Hotel getHotel(Integer hotel_id) {
		return hotelrepository.findById(hotel_id).orElseThrow(null);
	}

	public Hotel addHotel(Hotel hotel) {
		return hotelrepository.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return hotelrepository.save(hotel);
	}

	public void deleteById(int hotel_id) {
		hotelrepository.deleteById(hotel_id);
	}
	
	public Hotel searchById(int hotelId)
	{
		return hotelrepository.findById(hotelId).get();
	}
		
	public List<Hotel> getAllHotelWithSort(String field)
	{
		return hotelrepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	public List<Hotel> listAll(String keyword) {
		if (keyword != null) {
			return hotelrepository.search(keyword);
		}
		return hotelrepository.findAll();
	}

}
