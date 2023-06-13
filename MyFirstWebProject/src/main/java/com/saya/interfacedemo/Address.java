package com.saya.interfacedemo;

public class Address {
	private int doorNo;
	private String streetName;
	private int pincode;
	 final String state="tamilnadu";
public Address() {
	// TODO Auto-generated constructor stub
}

public Address(int doorNo, String streetName, int pincode) {
	super();
	this.doorNo = doorNo;
	this.streetName = streetName;
	this.pincode = pincode;
}

public int getDoorNo() {
	return doorNo;
}

public void setDoorNo(int doorNo) {
	this.doorNo = doorNo;
}



public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

public String getStreetName() {
	return streetName;
}

public void setStreetName(String streetName) {
	this.streetName = streetName;
}

@Override
public String toString() {
	return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", pincode=" + pincode + "]";
}



}
