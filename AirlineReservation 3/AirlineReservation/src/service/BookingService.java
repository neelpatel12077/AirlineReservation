package service;

import java.util.Scanner;
import dao.BookingDao;
import dao.FlightDao;
import userinterface.TestLogin;

public class BookingService {
    static Scanner s = new Scanner(System.in);
    TestLogin testlogin = new TestLogin();
    FlightDao flightdao = new FlightDao();
    BookingDao bookingdao = new BookingDao();

    // ANSI escape codes for coloring text
    private static final String RESET = "\033[0m";  // Reset color
    private static final String BLUE = "\033[34m";  // Blue text

    // Existing method to handle flight reservation
    public static void reservation() {
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("	****  Welcome to Airline Reservation System ****         ");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("  		    **** Please select an option ****                  ");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|-----------------------------------|");
        System.out.println("| Option | Description              |");
        System.out.println("|--------|--------------------------|");
        System.out.println("|   1    | View Flights             |");
        System.out.println("|   2    | Book Flight              |");
        System.out.println("|   3    | View Reservation         |");
        System.out.println("|   4    | Exit                     |");
        System.out.println("|-----------------------------------|");

        System.out.println("Select a choice:");

        int input = s.nextInt();
        switch (input) {
            case 1: {
            	viewFlights();                
                break;
            }
            case 2: {
            	bookFlight();
                break;
            }
            case 3: {
            	viewReservation();                
                break;
            }
            case 4: {
                System.out.println("|-----------------------------|");
                System.out.println("	**** Exit **** ");
                System.out.println("|-----------------------------|");
                System.out.println("Goodbye!");
                System.exit(0);  // Exit the program
                break;
            }
            default:
                System.err.println("!!!! Enter correct choice !!!!");
        }
    }

    public static void viewFlights() {
        System.out.println("|-----------------------------|");
        System.out.println("	**** View Flights ****     ");
        System.out.println("|-----------------------------|");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|FLIGHTID || FLIGHT_SOURCE || FLIGHT_DESTINATION || FLIGHT_DEPARTURE_DATE_TIME || FLIGHT_ARRIVAL_DATE_TIME || FLIGHT_FARE |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------------|");
        FlightDao.getFlight();
        System.out.println("|-------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("Choose from the following options:");
        System.out.println("1. Book Flight");
        System.out.println("2. View Reservation");
        int input = s.nextInt();
        handleBookingMenu(input);
        reservation();
    }

    public static void bookFlight() {
        System.out.println("|-----------------------------|");
        System.out.println("	 **** Book Flight ****     ");
        System.out.println("|-----------------------------|");
        getBookingDetails();
        System.out.println("|-------------------------------------------------------------------------------------------------------------------------|");
        reservation();
    }

    public static void viewReservation() {
        System.out.println("|-----------------------------|");
        System.out.println("   **** View Reservation ****  ");
        System.out.println("|-----------------------------|");
        System.out.println("Enter passenger ID: ");
        int input = s.nextInt();
        viewBooking(input); // Call viewBooking in BookingService
        reservation();
    }

    // Handle the flow for booking menu options
    private static void handleBookingMenu(int input) {
        switch (input) {
            case 1:
                System.out.println("|-----------------------------|");
                System.out.println("	 **** Book Flight ****	   ");
                System.out.println("|-----------------------------|");
                getBookingDetails();
                break;
            case 2:
                System.out.println("|-------------------------------------------------------|");
                System.out.println("   	**** View Reservation ****               ");
                System.out.println("|-------------------------------------------------------|");
                System.out.println("Enter passenger ID: ");
                input = s.nextInt();
                viewBooking(input); // View booking details
                break;
            default:
                System.err.println("Invalid choice! Please select again.");
        }
    }

    // Get booking details and insert into the database
    public static void getBookingDetails() {
        System.out.println("|-----------------------------|");
        System.out.println("	 === Booking Form ===	   ");
        System.out.println("|-----------------------------|");
        System.out.print(BLUE + "Enter Flight ID: " + RESET);
        int flightId = s.nextInt();
        System.out.print(BLUE + "Enter Passenger ID: " + RESET);
        int passengerId = s.nextInt();
        BookingDao.insertBooking(flightId, passengerId);
    }

    // View the booking based on the passenger ID
    public static void viewBooking(int passengerId) {
        // Call BookingDao to fetch and display the booking details for the given passenger ID
        BookingDao.viewBooking(passengerId);
    }
}
