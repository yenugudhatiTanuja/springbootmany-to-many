package com.spring.restapi.hms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.hms.model.Customer;
import com.spring.restapi.hms.service.CustomerService;

@RequestMapping("customer")
@RestController
public class CustomerController {
	@Autowired
	public CustomerService customerservice;

	@GetMapping("/customer")
	public List<Customer> getCustomer() {
		return this.customerservice.getCustomer();
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable Integer id) {
		return customerservice.getCustomer(id);
	}

	@PostMapping("/customersignin")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.customerservice.addCustomer(customer);
	}

	@PutMapping("/updatecustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Integer id) {
		customer.setcId(id);
		return this.customerservice.updateCustomer(customer);
	}

	@DeleteMapping("/deletecustomer/{id}")
	public void deleteById(@PathVariable Integer id) {
		customerservice.deleteById(id);
	}
}
