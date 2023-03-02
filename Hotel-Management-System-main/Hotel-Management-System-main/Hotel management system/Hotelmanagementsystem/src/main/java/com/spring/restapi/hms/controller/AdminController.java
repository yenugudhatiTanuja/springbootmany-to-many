package com.spring.restapi.hms.controller;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.hms.model.Admin;
import com.spring.restapi.hms.service.AdminService;


@RequestMapping("admin")
@RestController
public class AdminController {
	
	@Autowired
	public AdminService  adminservice;
	
	
	@GetMapping("/admin")
	public List<Admin> getAdmin(){
		return this.adminservice.getAdmin();
	}
	@GetMapping("/admin/{admin_id}")
	public   Admin getAdmin(@PathVariable Integer  admin_id) {
		return   adminservice.getAdmin(admin_id);
	}
	@PostMapping("/adminsignin")
	 public   Admin addAdmin(@RequestBody Admin admin) {
		 return this.adminservice.addAdmin(admin);
	 }
	@PutMapping("/updateadmin/{admin_id}")
	public Admin updateAdmin(@RequestBody Admin admin, @PathVariable Integer admin_id) {
		admin.setAdminId(admin_id);
		return this. adminservice.updateAdmin(admin);
	}
	/*@DeleteMapping("/deleteadmin/{admin_id}")
	public void deleteById(@PathVariable Integer admin_id) {
		adminservice.deleteById(admin_id);
	}*/
	
	
	@DeleteMapping("/deladmin/{id}")
	public String deleteAdminById(@PathVariable int id)
	{
		this.adminservice.deleteAdmin(id);
		return "Admin has been deleted";
	}
	
}
