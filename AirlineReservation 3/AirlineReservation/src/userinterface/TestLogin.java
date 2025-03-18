package userinterface;

import java.util.Scanner;
import dao.LoginDao;
import validation.LoginValidation;
import service.BookingService;
import service.FlightService;
import service.CustomerService;

public class TestLogin {

	static Scanner s = new Scanner(System.in);

	static {
		// Welcome message with border design
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("	  ****  Welcome to Airline Reservation System ****         ");
		System.out.println("|-------------------------------------------------------------------|");
	}

	public static void login() {
		// Initialize services and DAO objects
		LoginValidation loginValidation = new LoginValidation();
		CustomerService customerService = new CustomerService();
		// Prompt to enter user details
		System.out.println("|-------------------------------------------------------------------|");
		System.out.println("  		  **** Please select an option ****                  ");
		System.out.println("|-------------------------------------------------------------------|");
		// Validate login credentials
		if (loginValidation.checkAll()) {
			// Display successful login message
			System.out.println("|-----------------------------------|");
			System.out.println("	#### Login Successful ####		 ");
			System.out.println("|-----------------------------------|");
			LoginDao logindao = new LoginDao();
			if (logindao.checkUserType() == 1) {
				BookingService.reservation();
			} else if (logindao.checkUserType() == 2) {
				FlightService.flightDetails();
			}

			// Ask user if they want to continue
			System.out.println("|-----------------------------------|");
			System.out.println("	Do you want to continue? [Y/N]	 ");
			System.out.println("|-----------------------------------|");
			String choice = s.nextLine(); // Consume newline
			choice = s.nextLine(); // Read actual user input
			if (choice.equalsIgnoreCase("Y")) {
				login(); // Restart login after selection
			} else if (choice.equalsIgnoreCase("N")) {
				System.out.println("Goodbye!");
				// Exit the program
			}

		} else {
			// Handle failed login
			System.err.println("|-----------------------------------|");
			System.err.println("	#### Login Unsuccessful ####	 ");
			System.err.println("|-----------------------------------|");

			System.out.println("New user?");
			System.out.println("|-----------------------------------|");

			// Ask for signup option
			System.out.println("1. Sign Up");
			System.out.println("|-----------------------------------|");
			int input = s.nextInt();
			if (input == 1) {
				customerService.getdetails();
				login(); // Restart login after sign up
			}
		}
	}

	public static void main(String[] args) {
		// Create an instance and initiate login
		login();
	}
}
