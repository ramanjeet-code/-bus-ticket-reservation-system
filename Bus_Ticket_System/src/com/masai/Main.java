package com.masai;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Bus;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.service.BusService;
import com.masai.service.BusServiceEmpl;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
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
					//customerFunctionality(sc, customers, products, transactions);
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
				System.out.println("Press 1 add the product");
				System.out.println("Press 2 view all the product");
				System.out.println("Press 3 delete the product");
				System.out.println("Press 4 update the product");
				System.out.println("Press 5 view all customers");
				System.out.println("Press 6 to view all transactions");
				System.out.println("Press 7 to log out");
				choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				String added = adminAddProduct(sc, bus, busService);
				System.out.println(added);
				break;
			case 2:

				//adminViewAllProducts(products, prodService);
				break;
			case 3:

			//	adminDeleteProduct(sc, products, prodService);
				break;
			case 4:

				
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

	private static String adminAddProduct(Scanner sc, Map<Integer, Bus> bus, BusService busService) {
		// TODO Auto-generated method stub
		return null;
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
