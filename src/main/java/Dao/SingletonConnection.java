package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection{ 
	private static Connection connection;

static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiant_jsf","root","");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

public static Connection getConnection() {
	return connection;
}




}
