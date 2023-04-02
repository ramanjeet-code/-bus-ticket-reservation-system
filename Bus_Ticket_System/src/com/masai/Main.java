package com.masai;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Bus;
import com.masai.entities.Passenger;
import com.masai.entities.User;
//import com.masai.entities.Transaction;
import com.masai.exceptions.BusException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;

import com.masai.service.BusService;
import com.masai.service.BusServiceEmpl;
import com.masai.service.PassengerService;
import com.masai.service.PassengerServiceImpl;
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
		Map<String, Passenger> customers = FileExists.customerFile();
	//	List<Transaction> transactions = FileExists.transactionFile();

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
					passengerFunctionality(sc, customers, bus);
					break;

				case 3:
					passengerSignup(sc, customers);
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
	private static void passengerSignup(Scanner sc, Map<String, Passenger> passenger) throws DuplicateDataException {
		// TODO Auto-generated method stub
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("Enter the FirstName");
		String fName = sc.next();
		System.out.println("Enter the LastName");
		String lName = sc.next();
		System.out.println("Enter Mobile no");
		String  mob = sc.next();
		System.out.println("Enter the balance to be added into the wallet");
		double balance = sc.nextDouble();
		Passenger us=new Passenger(name,pass,fName,lName,mob,address,balance);
		PassengerService ps=new  PassengerServiceImpl(); 
		ps.SignUp(us, passenger);
		System.out.println("customer has Succefully sign up");
	}

	private static void passengerFunctionality(Scanner sc, Map<String, Passenger> customers, Map<Integer, Bus> bus) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		PassengerService pservice=new PassengerServiceImpl();
		BusService busService=new BusServiceEmpl();
		System.out.println("please enter the following details to login");
		System.out.println("please enter the UserName");
		String uName = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		customerLogin(uName,pass, customers, pservice);

		try {
			int choice = 0;
			do {
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to view Bus List");
				System.out.println("Press 2 to add money to a wallet");
				System.out.println("Press 3 view wallet balance");
				System.out.println("Press 4 Book Tickets");
				System.out.println("Press 5 Cancel Tickets");
				System.out.println("Press 6 to Booking History");
				System.out.println("Press 7 to Delete Account");
				System.out.println("Press 8 to logout");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					viewAllBuses(bus, busService);
					break;
				
//					String result = customerBuyProduct(sc, email, products, customers, transactions, cusService);
//					System.out.println(result);
					
				case 2:
					String moneyAdded = PassengerAddMoneyToWallet(sc, uName, customers, pservice);
					System.out.println(moneyAdded);
					break;
				case 3:
					double walletBalance = PassengerViewWalletBalance(uName, customers, pservice);
					System.out.println("Wallet balance is: " + walletBalance);
					break;
				case 4:
					 //	bookTicket(sc,uName,customers,psservice);
					break;
				case 5:
					//customerViewMyDetails(email, customers, pservice);
					break;
				case 6:
					//customerViewCustomerTransactions(email, transactions, trnsactionService);
					break;
				case 7:
					break;
				case 8:	
					System.out.println("you have successsfully logout");
					break;
				default:
					System.out.println("invalid choice");
					break;
				}

			} while (choice <= 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double PassengerViewWalletBalance(String uName, Map<String, Passenger> customers,
			PassengerService pservice) {
		// TODO Auto-generated method stub
		double walletBalance = pservice.viewWalletBalance(uName, customers);
		return walletBalance;
	
	}

	private static String PassengerAddMoneyToWallet(Scanner sc, String uName, Map<String, Passenger> customers,
			PassengerService pservice) {
		// TODO Auto-generated method stub
		System.out.println("please enter the amount");
		double money = sc.nextDouble();
		boolean res=pservice.addMoneyToWallet(money, uName, customers);
		return null;
	}

	private static void customerLogin(String uName, String pass, Map<String, Passenger> customers,
			PassengerService pservice) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		pservice.login(uName, pass,customers);
		System.out.println("Customer has successfully login");

		
	}

	private static void adminFunctionality(Scanner sc, Map<Integer, Bus> bus) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		adminLogin(sc);
		BusService busService=new BusServiceEmpl();
		int choice = 0;
		try {
			do {
				System.out.println("Press 1 add the Bus ");
				System.out.println("Press 2 View all Buses");
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

				String updated=updateBus(sc,bus,busService);
				System.out.println(updated);
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

	private static String updateBus(Scanner sc, Map<Integer, Bus> busMap, BusService busService) throws BusException {
		// TODO Auto-generated method stub
		
		String result = null;
		
		System.out.println("please enter the id of the Bus which is to be updated");
		int id = sc.nextInt();
		 

		//Bus bus = busMap.get(id);
		
		System.out.println("Enter the updated details ");
//
		System.out.println("Enter the Bus name");
   	String name = sc.next();
		System.out.println("Enter the BusType");
		String busType = sc.next();
		System.out.println("Enter the TotalSeat");
		int totalSeat = sc.nextInt();
		
		

	 
	//	System.out.println(bus);
		
			
	    result=busService.updateBus(id, name, totalSeat,busType,busMap);
	    return result;


		
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

		System.out.println("Enter the user name");
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
