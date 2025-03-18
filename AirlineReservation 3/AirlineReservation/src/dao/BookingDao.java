package dao;

import java.sql.*;

public class BookingDao {
    // ANSI escape codes for coloring text
    private static final String RESET = "\033[0m";  // Reset color
    private static final String YELLOW = "\033[33m";  // Yellow text (changed from blue)

    public static String insertBooking(int flightId, int passengerId) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String username = "system";
        String password = "12345";

        // Connection object
        Connection conn = null;

        String sql = "INSERT INTO booking (bookingId, flightId, passengerId, dateBooking) VALUES (bookingId.NEXTVAL, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, flightId);
            preparedStatement.setInt(2, passengerId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                connection.setAutoCommit(true);
                System.out.println("A new booking was done successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Successfully";
    }

    // Modified method to view booking details including passenger's name with highlighting
    public static void viewBooking(int passengerId) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";  // Replace with your DB connection URL
        String username = "system";  // Replace with your DB username
        String password = "12345";  // Replace with your DB password

        // Connection object
        Connection conn = null;

        // SQL query to fetch the booking information and passenger details
        String sql = "SELECT b.BOOKINGID, b.FLIGHTID, b.PASSENGERID, b.DATEBOOKING, p.PASSENGER_NAME "
                   + "FROM BOOKING b "
                   + "JOIN PASSENGER p ON b.PASSENGERID = p.PASSENGERID "
                   + "WHERE b.PASSENGERID = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the passengerId parameter
            preparedStatement.setInt(1, passengerId);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Print column headers (tabular format) - Only print once
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");
            System.out.println("   				**** Reservation Details ****                                        ");
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");
            System.out.printf("%-12s %-12s %-15s %-20s %-20s\n", "Booking ID", "Flight ID", "Passenger ID", "Date Booking", "Passenger Name  ");
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");

            // Print row data
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("BOOKINGID"); // Retrieve the BOOKINGID column
                int flightId = resultSet.getInt("FLIGHTID");   // Retrieve the FLIGHTID column
                int passengerIdFromDb = resultSet.getInt("PASSENGERID"); // Retrieve the PASSENGERID column
                Timestamp dateBooking = resultSet.getTimestamp("DATEBOOKING"); // Retrieve the DATEBOOKING column
                String passengerName = resultSet.getString("PASSENGER_NAME"); // Retrieve the PASSENGER_NAME column

                // Print the retrieved data with highlighted Passenger ID and Name
                System.out.printf("%-12d %-12d %-15s %-20s %-20s\n",
                        bookingId,
                        flightId,
                        YELLOW + passengerIdFromDb + RESET, // Highlight Passenger ID in yellow
                        dateBooking,
                        YELLOW + passengerName + RESET); // Highlight Passenger Name in yellow
            }

        } catch (SQLException e) {
            // Print exception message and stack trace for debugging
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to display passenger details by flight ID (Not used for displaying bookings)
    public static void displayPassenger(int flightId) {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";  // Replace with your DB connection URL
        String username = "system";  // Replace with your DB username
        String password = "12345";  // Replace with your DB password

        // Connection object
        Connection conn = null;

        // SQL query to fetch the booking information
        String sql = "SELECT b.BOOKINGID, b.FLIGHTID, b.PASSENGERID, b.DATEBOOKING, p.PASSENGER_NAME, p.PASSENGER_MOBILE "
                   + "FROM BOOKING b "
                   + "INNER JOIN PASSENGER p ON b.PASSENGERID = p.PASSENGERID "
                   + "WHERE b.FLIGHTID = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the flightId parameter
            preparedStatement.setInt(1, flightId);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Print column headers (tabular format) - Only print once
            System.out.println("|---------------------------------------------------------------------|");
            System.out.println("   **** Passenger Details for Flight ID: " + flightId + " **** ");
            System.out.println("|---------------------------------------------------------------------|");
            System.out.printf("%-12s %-12s %-15s %-20s %-20s %-15s\n", "Booking ID", "Flight ID", "Passenger ID", "Date Booking", "Passenger Name", "Passenger Mobile");
            System.out.println("|---------------------------------------------------------------------|");

            // Print row data
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("BOOKINGID"); // Retrieve the BOOKINGID column
                int flightIdFromDb = resultSet.getInt("FLIGHTID");   // Retrieve the FLIGHTID column
                int passengerIdFromDb = resultSet.getInt("PASSENGERID"); // Retrieve the PASSENGERID column
                Timestamp dateBooking = resultSet.getTimestamp("DATEBOOKING"); // Retrieve the DATEBOOKING column
                String passengerName = resultSet.getString("PASSENGER_NAME");
                String passengerMobile = resultSet.getString("PASSENGER_MOBILE");

                // Print the retrieved data with highlighted Passenger ID and Name
                System.out.printf("%-12d %-12d %-15s %-20s %-20s %-15s\n",
                        bookingId,
                        flightIdFromDb,
                        YELLOW + passengerIdFromDb + RESET, // Highlight Passenger ID in yellow
                        dateBooking,
                        YELLOW + passengerName + RESET, // Highlight Passenger Name in yellow
                        passengerMobile);
            }

        } catch (SQLException e) {
            // Print exception message and stack trace for debugging
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
