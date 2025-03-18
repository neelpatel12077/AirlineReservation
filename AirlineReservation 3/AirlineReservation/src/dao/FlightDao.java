package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import entity.Flight;
import service.*;

public class FlightDao {
	FlightService flightservice = new FlightService();
	static Scanner s = new Scanner(System.in);
	public static String insertFlight(int flight_Id, String flight_source, String flight_destination,
			String flight_departure_date_time, String flight_arrival_date_time, int flight_fare) {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "system";
		String password = "12345";
		Connection conn = null;

		String sql = "INSERT INTO Flight (FLIGHTID, FLIGHT_SOURCE, FLIGHT_DESTINATION, FLIGHT_DEPARTURE_DATE_TIME, FLIGHT_ARRIVAL_DATE_TIME, FLIGHT_FARE) VALUES (?, ?, ?, ?, ?, ?)";
		Timestamp sd = Timestamp.valueOf(flight_departure_date_time);
		Timestamp ed = Timestamp.valueOf(flight_arrival_date_time);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, flight_Id);
			preparedStatement.setString(2, flight_source);
			preparedStatement.setString(3, flight_destination);
			preparedStatement.setTimestamp(4, sd);
			preparedStatement.setTimestamp(5, ed);
			preparedStatement.setInt(6, flight_fare);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				connection.setAutoCommit(true);
				System.out.println("#### Flight addition Successful ####!");
				System.out.println("Continue by ");
				System.out.println("1. Inserting more flights");
				System.out.println("2. Going back to menu");
				System.out.println("-- enter your choice --");
				int ch = s.nextInt();
				if(ch==1)
				{
					FlightService.getFlightDetails();
				}
				else if(ch==2)
				{
					FlightService.flightDetails();
				}
				else
				{
					System.err.println("!!!! Enter correct choice !!!!");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Flight Created Successfully.Database";
	}

	public static void getFlight() {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String username = "system";
        String password = "12345"; 
        String sql = "SELECT * FROM flight";
        
        // Try-with-resources block to automatically close resources
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            // Set the flightId parameter in the query
            
            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Check if the result set contains data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers (tabular format) - Only print once
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t" + "\t"); // Print column name
            }
            System.out.println(); // Newline after column names

            // Print row data
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print("\t" + resultSet.getString(i) + "\t" + "\t"); // Print row data
                }
                System.out.println(); // Newline after each row
            }
		}
        
            
         catch (SQLException e) {
            // Print exception message and stack trace for debugging
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

	public static String updateFlight(int flight_Id, String flight_source, String flight_destination,
			String FLIGHT_DEPARTURE_DATE_TIME, String FLIGHT_ARRIVAL_DATE_TIME, float flight_fare) {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "system";
		String password = "12345";
		Timestamp sd = Timestamp.valueOf(FLIGHT_DEPARTURE_DATE_TIME);
		Timestamp ed = Timestamp.valueOf(FLIGHT_ARRIVAL_DATE_TIME);
		// Connection object
		Connection conn = null;

		String sql = "UPDATE Flight SET flight_source = ?, flight_destination = ?, FLIGHT_DEPARTURE_DATE_TIME  = ?, "
				+ "FLIGHT_ARRIVAL_DATE_TIME = ?, flight_fare = ? WHERE flightId = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, flight_source);
			preparedStatement.setString(2, flight_destination);
			preparedStatement.setTimestamp(3, sd);
			preparedStatement.setTimestamp(4, ed);
			preparedStatement.setFloat(5, flight_fare);
			preparedStatement.setInt(6, flight_Id);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Flight details updated successfully!");
				connection.setAutoCommit(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Flight Updated Successfully. Database.";
	}

	public static String deleteFlight(int flight_Id) {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "system";
		String password = "12345";

		// Connection object
		Connection conn = null;

		String sql = "DELETE FROM FLIGHT WHERE flightId = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, flight_Id);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Flight deleted successfully!");
				connection.setAutoCommit(true);
			} else {
				System.out.println("Flight not found or already deleted.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Flight Deleted Successfully. Database.";
	}

}
