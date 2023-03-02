package com.spring.restapi.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.restapi.hms.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
	 @Query("SELECT  h  FROM  Hotel  h WHERE  CONCAT(h.hotelName,h.hotelCity)LIKE  %?1%")
	 public List<Hotel> search (String keyword);	 
} 
     