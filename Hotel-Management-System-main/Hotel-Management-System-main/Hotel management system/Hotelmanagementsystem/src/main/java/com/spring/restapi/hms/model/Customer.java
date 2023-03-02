package com.spring.restapi.hms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private @NotNull int cId;
	
	@Column(name = "name")
	@Size(min=3 , message="adminName must contain atleast 3 characters")
	private @NotNull String cName;
	
	@Column(name = "username")
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	private @NotNull String userName;
	
	@Column(name = "password")
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits and special characters")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@%#$^&*]).{8,}")
	private @NotNull String password;
	
	@Column(name = "email",unique=true)
	@Email(message="Email  is not valid!")
	private @NotNull String email;
	
	@Column(name = "phoneno")
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private @NotNull String phoneNo;
	
	@Column(name="district")
	@NotNull
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String district;
	
	@Column(name="state")
	@NotNull
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String state;
	
	@Column(name="zip_code")
	@NotNull
	@Size(min=6 ,max=6, message="zipCode must contain 6 digits")
	private String zipCode;
	
	@Column(name = "country")
	@Size(min=3 , message="district must contain atleast 3 characters")
	private @NotNull String country;
	
	@Column(name="gender")
	@NotNull
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String gender;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
