package com.masai.entities;

import java.io.Serializable;

public class Passenger extends User implements Serializable {

	private double walletBalance;
	public Passenger(String name, String pass, String fName, String lName, String mob, String address, double balance) {
		// TODO Auto-generated constructor stub
		super(name,pass,fName,lName, mob, address);
		this.walletBalance=balance;
	}
	public double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	@Override
	public String toString() {
		return "Passenger [walletBalance=" + walletBalance + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getMobileNo()=" + getMobileNo() + ", getAddress()=" + getAddress()
				+ "]";
	}
	
	

	

}
