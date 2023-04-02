package com.masai.service;

import java.util.Map;

import com.masai.entities.Passenger;
import com.masai.entities.User;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

public interface PassengerService {

	boolean login(String uName, String pass, Map<String, Passenger> customers) throws InvalidDetailsException;

	void SignUp(Passenger us, Map<String, Passenger> passenger) throws DuplicateDataException;

	boolean addMoneyToWallet(double money, String uName, Map<String, Passenger> customers);

	double viewWalletBalance(String uName, Map<String, Passenger> customers);




	

}
