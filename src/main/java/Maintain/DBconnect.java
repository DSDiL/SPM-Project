package techscope;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private static String url="jdbc:mysql://localhost:3306/darkshop";
	private static String user="root";
	private static String password="luna";
	private static Connection con;

	public static Connection getConnection() {

	try {
		Class.forName("com.mysql.jdbc.Driver");
	
		con=DriverManager.getConnection(url,user,password);
	}catch(Exception e){
		System.out.println("Database connection is not successfull!!");
	}
	return con;

}
}