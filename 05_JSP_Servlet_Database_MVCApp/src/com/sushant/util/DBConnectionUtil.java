package com.sushant.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	//Define DB properties
	
	private static final String userName = "root";
	private static final String password ="abc123ABC";
	private static final String jdbcURL ="jdbc:mysql://localhost:3306/employeedirectory?useSSL=false";
	private static final String driver ="com.mysql.cj.jdbc.Driver";
	private static Connection  connection =null;
	
	
	//Define Static method
	
	public static Connection openConnection() {
		
		//Check Connection
		if(connection != null) {
			return connection;
		}
		//Load the driver
		try {
			Class.forName(driver);
			// Get the Connection
			connection=DriverManager.getConnection(jdbcURL,userName,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//return Connection
		return connection;
		
		
	}

}
