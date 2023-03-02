package com.spring.restapi.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(generator = "Id_generator1")
	@GenericGenerator(name = "Id_generator1",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="booking_sequence"),
								      @Parameter(name ="initial_value",value="100"),
									  @Parameter(name="increment_size",value = "1")})
	@Column(name = "booking_id")
	private @NotNull int bookingId;
	
	
	@Column(name = "hotel_name")
	@Size(min=3 , message="adminName must contain atleast 3 characters")
	private @NotNull String hotelName;
	
	@Column(name = "rooms")
	private @NotNull int rooms;
	
	@Column(name = "email",unique=true)
	@Email(message="Email  is not valid!")
	private @NotNull String email;
	
	@Column(name = "noOfPeople")
	private @NotNull int noOfPeople;
	
	@Column(name = "entrydate_of_booking")
	@Size(min=10 ,max=10, message="give date Properly")
	private @NotNull String entryDate;
	
	@Column(name = "existdate_of_booking")
	@Size(min=10 ,max=10, message="give date Properly")
	private @NotNull String existDate;
		
	@Column(name = "Entry_time")
	@Size(min=5 ,max=5, message="give time in the format of 00:00")
	private @NotNull String entryTime;
	
	@Column(name = "Exist_time")
	@Size(min=5 ,max=5, message="give time in the format of 00:00")
	private @NotNull String existTime;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_id")
     private Customer ctr;

	
	public Customer getCtr() {
		return ctr;
	}

	public void setCtr(Customer ctr) {
		this.ctr = ctr;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
     
	
	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExistDate() {
		return existDate;
	}

	public void setExistDate(String existDate) {
		this.existDate = existDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExistTime() {
		return existTime;
	}

	public void setExistTime(String existTime) {
		this.existTime = existTime;
	}

	

	public Booking(@Size(min = 3, message = "adminName must contain atleast 3 characters") String hotelName, int rooms,
			@Email(message = "Email  is not valid!") String email, int noOfPeople,
			@Size(min = 10, max = 10, message = "give date Properly") String entryDate,
			@Size(min = 10, max = 10, message = "give date Properly") String existDate,
			@Size(min = 5, max = 5, message = "give time in the format of 00:00") String entryTime,
			@Size(min = 5, max = 5, message = "give time in the format of 00:00") String existTime) {
		super();
		this.hotelName = hotelName;
		this.rooms = rooms;
		this.email = email;
		this.noOfPeople = noOfPeople;
		this.entryDate = entryDate;
		this.existDate = existDate;
		this.entryTime = entryTime;
		this.existTime = existTime;
	}
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

}
