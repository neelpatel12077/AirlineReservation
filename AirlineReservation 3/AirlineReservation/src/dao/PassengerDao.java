package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class PassengerDao {
	public static String insertPassenger(String passenger_name,String passenger_mobile,String passenger_address, String upassword) {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "system";
		String password = "12345";
 
		// Connection object
		Connection conn = null;
 
		String sql = "INSERT INTO Passenger (passengerId,passenger_name,passenger_mobile,passenger_address,password,type) VALUES (PASSENGERID.NEXTVAL,?,?,?,?,1)";
		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, passenger_name);
			preparedStatement.setString(2, passenger_mobile);
			preparedStatement.setString(3, passenger_address);
			preparedStatement.setString(4, upassword);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				connection.setAutoCommit(true);
				System.out.println("A new passenger added successfully!");
				System.out.println("Please note following detail for further use:");
			        String passengerName = passenger_name;  // Example passenger name
			        int passengerId = getPassengerIdByName(passengerName);
			        System.out.println("Passenger ID: " + passengerId);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Successfully";
	}
	public static int getPassengerIdByName(String passengerName)
	{
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String username = "system";
		String password = "12345";
		  int passengerId = -1; 
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            conn = DriverManager.getConnection(url, username, password);
	             String sql = "SELECT PASSENGERID FROM PASSENGER WHERE PASSENGER_NAME = ?";
	            pstmt = conn.prepareStatement(sql);           
	            pstmt.setString(1, passengerName);
	           rs = pstmt.executeQuery();
	         if (rs.next()) {
	                passengerId = rs.getInt("PASSENGERID");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return passengerId;
	}

 
}