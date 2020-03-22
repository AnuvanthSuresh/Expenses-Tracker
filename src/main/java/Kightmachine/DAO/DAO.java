package Kightmachine.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private static String password = "pass123";
	private static String username = "admin_ET";
	private static String url = "jdbc:postgresql://localhost:5432/expensetracker";
	public Connection connection = null;

	// Get Connection

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successful");
			return connection;
		} catch (Exception e) {

			System.out.println("Connection Failed");
			return connection;
		}
	}

	// Drop Connection

	public void dropConnection() {
		try {
			connection.close();
			System.out.println("Connection Dropped");
		} catch (Exception e) {

			System.out.println("Connection close failed");
		}
	}

}
