package com.masai;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Bus;
import com.masai.exceptions.BusException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.service.BusService;
import com.masai.service.BusServiceEmpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
import com.masai.utility.IDGeneration;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Bus> bus = FileExists.productFile();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome , in Bus Ticket Reservation System");
		try {

			int preference = 0;
			do {
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> Passenger login , "
				+ "'3' for Passenger signup, '0' for exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					adminFunctionality(sc, bus);
					break;
				case 2:
					//viewAllBuses(bus,)
					break;

				case 3:
					//customerSignup(sc, customers);
					break;

				case 0:
					System.out.println("successfully existed from the system");

					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}

			}

			while (preference != 0);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
	private static void adminFunctionality(Scanner sc, Map<Integer, Bus> bus) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		adminLogin(sc);
		BusService busService=new BusServiceEmpl();
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 add the Bus ");
				System.out.println("Press 2 View all bookings");
				System.out.println("Press 3  Delete bus details");
				System.out.println("Press 4 Update bus details");
				System.out.println("Press 7 to log out");
				choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				String added = adminAddProduct(sc, bus, busService);
				System.out.println(added);
				break;
			case 2:

				//adminViewAllProducts(products, prodService);
				viewAllBuses(bus,busService);
				break;
			case 3:

				adminDeleteBus(sc, bus, busService);
				break;
			case 4:

				updateBus(sc,bus,busService);
				break;
			case 5:
				//adminViewAllCustomers(customers, cusService);

				break;
			case 6:
				//adminViewAllTransactions(transactions, trnsactionService);
				break;
			case 7:
				System.out.println("admin has successfully logout");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}

		} while (choice <= 6);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}

	private static void updateBus(Scanner sc, Map<Integer, Bus> bus, BusService busService) throws BusException {
		// TODO Auto-generated method stub
		String result = null;
		System.out.println("please enter the id of the Bus which is to be updated");
		int id = sc.nextInt();
//		System.out.println("Enter the updated details ");
//
//		System.out.println("Enter the Bus name");
//		String name = sc.next();
//		System.out.println("Enter the BusType");
//		String busType = sc.next();
//		System.out.println("Enter the TotalSeat");
//		int totalSeat = sc.nextInt();
		if (bus != null && bus.size() > 0) {
			if(bus.containsKey(id)) {
				System.out.println(bus);
			}

		} else {
			throw new BusException("Product List is empty");
		}
	//	System.out.println(bus);
		
		//	Bus update=new Bus(id,name,busType,totalSeat);
	}

	private static void adminDeleteBus(Scanner sc, Map<Integer, Bus> bus, BusService busService) throws BusException{
		// TODO Auto-generated method stub
		System.out.println("please enter the id of Bus to be deleted");
		int id = sc.nextInt();
		busService.deleteBus(id, bus);
		
	}

	private static void viewAllBuses(Map<Integer, Bus> bus, BusService busService) throws BusException {
		// TODO Auto-generated method stub
		busService.viewAllBuses(bus);
	}

	private static String adminAddProduct(Scanner sc, Map<Integer, Bus> bus, BusService busService) {
		// TODO Auto-generated method stub
		String str = null;
		System.out.println("please enter the Bus details");
		System.out.println("Enter the Bus name");
		String name = sc.next();
		System.out.println("Enter the totalseat");
		int totalseat = sc.nextInt();
		System.out.println("Enter the source");
		String scource = sc.next();
		System.out.println("Enter the Destination");
		String destination = sc.next();
		System.out.println("Enter the Bus Type");
		String busType = sc.next();
		System.out.println("Enter the Bus number");
		String busNumber = sc.next();
		System.out.println("Enter the Arrival Time");
		String ArrT = sc.next();
		System.out.println("Enter the Departure Time");
		String depTime = sc.next();
	
		Bus buses=new Bus(IDGeneration.generateId(), name, totalseat, scource, destination, busType, depTime, ArrT,busNumber);
	  str=busService.addBus(buses, bus);
		return str;
	}

	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the User Name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
			
		}
	}

}
