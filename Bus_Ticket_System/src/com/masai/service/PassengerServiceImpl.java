package com.masai.service;

import java.util.Map;


import com.masai.entities.Passenger;
import com.masai.entities.User;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

public class PassengerServiceImpl implements PassengerService {

	@Override
	public boolean login(String uName, String pass, Map<String, Passenger> customers) throws InvalidDetailsException {
if (customers.containsKey(uName) ) {
			
			if(customers.get(uName).getPassword().equals(pass)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
		//return false;
	}

	@Override
	public void SignUp(Passenger us, Map<String, Passenger> passenger) throws DuplicateDataException {
		// TODO Auto-generated method stub
		if (passenger.containsKey(us.getUsername())) {
			throw new DuplicateDataException("Customer already exists , please login");
		} else {

			passenger.put(us.getUsername(), us);

		}
	}

	@Override
	public boolean addMoneyToWallet(double money, String uName, Map<String, Passenger> customers) {
		Passenger cus = customers.get(uName);

		cus.setWalletBalance(cus.getWalletBalance() + money);

		customers.put(uName, cus);

		return true;
		
	}

	@Override
	public double viewWalletBalance(String uName, Map<String, Passenger> customers) {
		// TODO Auto-generated method stub
		Passenger ps= customers.get(uName);
		 
		return ps.getWalletBalance();
	}

}
