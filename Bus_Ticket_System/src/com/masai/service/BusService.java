package com.masai.service;

import java.util.Map;

import com.masai.entities.Bus;
import com.masai.exceptions.BusException;


public interface BusService {
	public String addBus(Bus pro, Map<Integer, Bus> products);

	public void viewAllBuses(Map<Integer, Bus> products) throws BusException;

	public void deleteBus (int id, Map<Integer, Bus> products) throws BusException;

	public String updateBus (int id, Bus prod, Map<Integer, Bus> products) throws BusException;

}
