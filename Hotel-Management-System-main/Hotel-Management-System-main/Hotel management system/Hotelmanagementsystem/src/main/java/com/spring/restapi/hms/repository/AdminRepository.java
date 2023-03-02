package com.spring.restapi.hms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restapi.hms.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	//Optional<Admin> findByEmailAndPassword(String email,String password);

}
