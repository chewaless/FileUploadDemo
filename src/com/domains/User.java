package com.domains;

public class User {  
private int id;  
private String mobileNumber;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
@Override
public String toString() {
	return "User [id=" + id + ", mobileNumber=" + mobileNumber + "]";
} 

}  
