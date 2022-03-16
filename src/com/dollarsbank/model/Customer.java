package com.dollarsbank.model;

public class Customer {

	String fullName;
	String address;
	String phoneNum;
	String userID;
	String password;

	public Customer() {
	}

	public Customer(String fullName, String address, String phoneNum, String userID, String password) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phoneNum = phoneNum;
		this.userID = userID;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\n| Full Name: " + fullName + " | Address: " + address + " | Phone Number: " + phoneNum
				+ " | User ID = " + userID + " | Password: " + password + " |";
	}

}
