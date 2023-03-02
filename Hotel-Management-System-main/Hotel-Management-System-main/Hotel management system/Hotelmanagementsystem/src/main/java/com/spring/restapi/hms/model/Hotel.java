package com.spring.restapi.hms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Hotel")
public class Hotel implements Serializable{
	@Id
	@GeneratedValue(generator = "Id_generator")
	@GenericGenerator(name = "Id_generator",strategy ="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters = {@Parameter(name="sequence_name", value="hotel_sequence"),
								      @Parameter(name ="initial_value",value="1000"),
									  @Parameter(name="increment_size",value = "1")})
	@Column(name = "hotel_id")
	private @NotNull int hotelId;
	
	@Column(name = "hotel_name")
	@Size(min=3 , message="hotelName must contain atleast 3 characters")
	private @NotNull String hotelName;
	
	@Column(name = "hotel_city")
	@Size(min=3 , message="hotelCity must contain atleast 3 characters")
	private @NotNull String hotelCity;
	
	@Column(name = "room_type")
	@Size(min=4 , message="hotelName must contain atleast 3 characters")
	private @NotNull String roomType;
	
	@Column(name = "room_price_per_day")
	private @NotNull int roomPricePerDay;
	
	@Column(name = "available_rooms")
	private @NotNull int availableRooms;
	
	@Column(name = "hotel_Review")
	@Size(min=3 , message="hotelReview must contain atleast 3 characters")
	private @NotNull String hotelReview;
	
	@Column(name = "hotel_phonenumber")
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private @NotNull String hotelPhoneNo;
	
	@Column(name = "hotel_Rating")
	@Size(min=1 ,max=1, message="Rating must be 0-9 applicable")
	@Pattern(regexp="(?=.\\d).{1,}")
	private @NotNull String hotelRating;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "admin_id")
	private Admin adm;

	public Admin getAdm() {
		return adm;
	}

	public void setAdm(Admin adm) {
		this.adm = adm;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomPricePerDay() {
		return roomPricePerDay;
	}

	public void setRoomPricePerDay(int roomPricePerDay) {
		this.roomPricePerDay = roomPricePerDay;
	}


	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public String getHotelReview() {
		return hotelReview;
	}

	public void setHotelReview(String hotelReview) {
		this.hotelReview = hotelReview;
	}

	public String getHotelPhoneNo() {
		return hotelPhoneNo;
	}

	public void setHotelPhoneNo(String hotelPhoneNo) {
		this.hotelPhoneNo = hotelPhoneNo;
	}

	

	public String getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}

	

	public Hotel(@Size(min = 3, message = "hotelName must contain atleast 3 characters") String hotelName,
			@Size(min = 3, message = "hotelCity must contain atleast 3 characters") String hotelCity,
			@Size(min = 4, message = "hotelName must contain atleast 3 characters") String roomType,
			int roomPricePerDay, int availableRooms,
			@Size(min = 3, message = "hotelReview must contain atleast 3 characters") String hotelReview,
			@Size(min = 10, max = 10, message = "phoneNumber must contain  10 digits") String hotelPhoneNo,
			@Size(min = 1, max = 1, message = "Rating must be 0-9 applicable") @Pattern(regexp = "(?=.\\d).{1,}") String hotelRating) {
		super();
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.roomType = roomType;
		this.roomPricePerDay = roomPricePerDay;
		this.availableRooms = availableRooms;
		this.hotelReview = hotelReview;
		this.hotelPhoneNo = hotelPhoneNo;
		this.hotelRating = hotelRating;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

}