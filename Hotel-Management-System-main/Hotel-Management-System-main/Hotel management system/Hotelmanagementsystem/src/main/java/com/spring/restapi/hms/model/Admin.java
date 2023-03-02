package com.spring.restapi.hms.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private @NotNull int adminId;
	
	@Column(name = "admin_name")
	@Size(min=3 , message="adminName must contain atleast 3 characters")
	private @NotNull String adminName;
	
	@Column(name = "email",unique=true)
	@Email(message="Email  is not valid!")
	public @NotNull String email;
	
	@Column(name = "password")
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits and special characters")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@%#$^&*]).{8,}")
	public @NotNull String password;

	@JsonIgnore
	@OneToMany(mappedBy="adm", cascade = CascadeType.ALL)
	private Set<Hotel> hts;

	public Set<Hotel> getHts() {
		return hts;
	}

	public void setHts(Set<Hotel> hts) {
		this.hts = hts;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String adminName, String email, String password) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
