package employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnect {

	private static String url = "jdbc:mysql://localhost:3306/darkshop";
	private static String userName = "root";
	private static String password = "kl654321";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is failed");
		}
		
		return con;
		
	}
	
	

}

