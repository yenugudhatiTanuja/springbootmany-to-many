package com.spring.restapi.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.restapi.hms.model.Admin;
import com.spring.restapi.hms.model.Customer;
import com.spring.restapi.hms.repository.CustomerRepository;

@Service
public class CustomerService{
@Autowired
public CustomerRepository customerrepository;
public List<Customer> getCustomer() {
	return  customerrepository.findAll();	
}
 public Customer addCustomer(Customer customer){
	 return customerrepository.save(customer);
 }

	public Customer getCustomer(Integer id) {
		return customerrepository.findById(id).orElseThrow(null);
	}
	public  Customer updateCustomer(Customer customer) {
		return  customerrepository.save(customer);
	}
	public Customer searchById(Integer cId)
	{
		return customerrepository.findById(cId).get();
	}
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		customerrepository.deleteById(id);
	}
	 
	 }

