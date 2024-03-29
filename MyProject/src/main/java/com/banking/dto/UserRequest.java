package com.banking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	
	@NotNull(message = "userName should not be null")
	private String userName;
	
	@Min(18)
	@Max(60)
	private int age;
	
	@Email(message="invalid mail address")
	private String email;
	
	@Pattern(regexp="^\\d{10}$", message= "invalid mobile number")
	private String phoneNumber;
	
	private String userAddress;
	
	private String accountType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", age=" + age + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", userAddress=" + userAddress + ", accountType=" + accountType + "]";
	}
	
}
