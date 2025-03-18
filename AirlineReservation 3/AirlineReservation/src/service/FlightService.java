package service;

import java.util.Scanner;
import dao.BookingDao;
import dao.FlightDao;
import userinterface.TestLogin;

public class FlightService {

    static Scanner s = new Scanner(System.in);
    TestLogin testlogin = new TestLogin();
    BookingDao bookingdao = new BookingDao();
    static FlightDao flightdao = new FlightDao();
    static int input;

    // ANSI escape codes for colors
    public static final String BLUE = "\033[0;34m";   // Blue color for Flight ID
    public static final String PINK = "\033[38;5;213m"; // Pink color for Departure and Arrival date/time
    public static final String RESET = "\033[0m"; // Reset color to default

    public static void flightDetails() {
        // Border Design for Flight Options
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                    **** Please select an option ****                  ");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|1. View Flights        |");
        System.out.println("|2. Add Flights         |");
        System.out.println("|3. Update Flight       |");
        System.out.println("|4. Delete flight       |");
        System.out.println("|5. View Passengers     |");
        System.out.println("|6. Exit                |");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");

        input = s.nextInt();

        switch (input) {
            case 1: {
                viewFlight();
                break;
            }
            case 2: {
                getFlightDetails();
                break;
            }
            case 3: {
                updateFlightDetails();
                break;
            }
            case 4: {
                deleteFlightDetails();
                break;
            }
            case 5: {
                viewPassenger();
                break;
            }
            case 6: {
                // Goodbye message and exit program
                System.out.println("|-----------------------------------|");
                System.out.println("         **** Goodbye ****            ");
                System.out.println("|-----------------------------------|");
                System.exit(0); // Exit the program
                break;
            }
            default:
                System.err.println("!!!! Enter correct choice !!!!");
        }
    }

    public static void viewFlight() {
        // Border Design for View Flights
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
        System.out.println("      					 **** View Flights ****			       		 ");
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");

        // Fetch and display all flights with colored output
        FlightDao.getFlight();  // This should print the flight list with colors
        flightDetails();
        System.out.println("|-------------------------------------------------------------------------------------------------------------------|");
    }

    public static void getFlightDetails() {
        // Border Design for Add Flight
        System.out.println("|-----------------------------------|");
        System.out.println("        **** Add Flight ****         ");
        System.out.println("|-----------------------------------|");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter flight ID: ");
        int FLIGHTID = s.nextInt();
        s.nextLine();
        System.out.print("Enter Source: ");
        String FLIGHT_SOURCE = s.nextLine();
        System.out.print("Enter Destination: ");
        String FLIGHT_DESTINATION = s.nextLine();
        System.out.print("Enter Departure date and time: ");
        String FLIGHT_DEPARTURE_DATE_TIME = s.nextLine();
        System.out.print("Enter Arrival date and Time: ");
        String FLIGHT_ARRIVAL_DATE_TIME = s.nextLine();
        System.out.print("Enter flight fare: ");
        int FLIGHT_FARE = s.nextInt();

        FlightDao.insertFlight(FLIGHTID, FLIGHT_SOURCE, FLIGHT_DESTINATION, FLIGHT_DEPARTURE_DATE_TIME, FLIGHT_ARRIVAL_DATE_TIME, FLIGHT_FARE);
        flightDetails();
    }

    public static void updateFlightDetails() {
        // Border Design for Update Flight
        System.out.println("|-----------------------------------|");
        System.out.println("        **** Update Flight ****      ");
        System.out.println("|-----------------------------------|");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter flight ID: ");
        int FLIGHTID = s.nextInt();
        s.nextLine();
        System.out.print("Enter Source: ");
        String FLIGHT_SOURCE = s.nextLine();
        System.out.print("Enter Destination: ");
        String FLIGHT_DESTINATION = s.nextLine();
        System.out.print("Enter Departure date and time: ");
        String FLIGHT_DEPARTURE_DATE_TIME = s.nextLine();
        System.out.print("Enter Arrival date and Time: ");
        String FLIGHT_ARRIVAL_DATE_TIME = s.nextLine();
        System.out.print("Enter flight fare: ");
        int FLIGHT_FARE = s.nextInt();

        FlightDao.updateFlight(FLIGHTID, FLIGHT_SOURCE, FLIGHT_DESTINATION,
                FLIGHT_DEPARTURE_DATE_TIME, FLIGHT_ARRIVAL_DATE_TIME, FLIGHT_FARE);
        flightDetails();
    }

    public static void deleteFlightDetails() {
        // Border Design for Delete Flight
        System.out.println("|-----------------------------------|");
        System.out.println("        **** Delete Flight ****      ");
        System.out.println("|-----------------------------------|");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter flight ID: ");
        int FLIGHTID = s.nextInt();
        FlightDao.deleteFlight(FLIGHTID);
        flightDetails();
    }

    public static void viewPassenger() {
        // Border Design for View Passengers
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("        **** View Passengers ****    ");
        System.out.println("|-------------------------------------------------------------------|");

        System.out.print("Enter flight id: ");
        int input = s.nextInt();
        BookingDao.displayPassenger(input);
        flightDetails();
    }
}
