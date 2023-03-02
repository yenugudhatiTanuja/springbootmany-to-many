package com.spring.restapi.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restapi.hms.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

}
