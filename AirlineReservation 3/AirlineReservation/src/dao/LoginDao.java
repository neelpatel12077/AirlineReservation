package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDao {
    static int input;

    // Method to check login and retrieve user name
    public static boolean checkLogin() {
        boolean flag = false;

        // Database connection details
        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Update with your DB URL
        String username = "system";  // Replace with your DB username
        String password = "12345";  // Replace with your DB password

        Scanner s = new Scanner(System.in);  // Don't close Scanner for System.in

        // User input for mobile and password
        System.out.println("Enter mobile number: ");
        String user_mobile = s.next();  // Read user mobile

        System.out.println("Enter password: ");
        String user_password = s.next();  // Read user password

        // Ask for user type (Customer or Admin)
        System.out.println("Login as: 1. Customer 2. Admin");
        input = s.nextInt();

        // SQL query to check user credentials and fetch name
        String sql = "SELECT passenger_name FROM passenger WHERE passenger_mobile = ? AND password = ? AND type=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Setting the parameters for the query
            preparedStatement.setString(1, user_mobile);
            preparedStatement.setString(2, user_password);
            preparedStatement.setInt(3, input);

            // Execute the query and check the result
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { // If a matching row is found
                    // Login successful, retrieve user's name
                    String userName = resultSet.getString("passenger_name");  // Fetch the passenger name
                    System.out.println("Hello, " + userName + "!");
                    flag = true;
                } else {
                    // No matching row found, login unsuccessful
                    flag = false;
                }
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        }

        return flag; // Return the result of login check
    }

    // Method to return the user type (Customer or Admin)
    public int checkUserType() {
        return input; // Return the user type
    }
}
