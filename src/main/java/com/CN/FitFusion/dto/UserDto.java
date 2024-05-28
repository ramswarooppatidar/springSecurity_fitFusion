package com.CN.FitFusion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	 String email;

     String password;

     int age;

     String gender;

     Long contactNo;

     String userType ;		 // ("ADMIN", "CUSTOMER", "TRAINER")

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserDto(String email, String password, int age, String gender, Long contactNo, String userType) {
		super();
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.userType = userType;
	}
     
	public UserDto() {
		
	}
}
