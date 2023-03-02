package com.spring.restapi.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.hms.model.Admin;
import com.spring.restapi.hms.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	public AdminRepository adminrepository;

	public List<Admin> getAdmin() {
		return adminrepository.findAll();
	}

	public Admin getAdmin(Integer admin_id) {
		return adminrepository.findById(admin_id).orElseThrow(null);
	}

	public Admin addAdmin(Admin admin) {
		return adminrepository.save(admin);
	}
	
	/*public Admin loginAdmin(Admin admin) {
		return this.adminrepository.findByEmailAndPassword(admin.email ,admin.password);
	}*/
	public Admin searchById(Integer adminId)
	{
		return adminrepository.findById(adminId).get();
	}

	public Admin updateAdmin(Admin admin) {
		return adminrepository.save(admin);
	}
   public void deleteAdmin(Integer adminId) {
		
		adminrepository.deleteById(adminId);			
	}
	/*
	 * public void deleteById(int admin_id) { // TODO Auto-generated method stub
	 * adminrepository.deleteById(admin_id); }
	 */
}
