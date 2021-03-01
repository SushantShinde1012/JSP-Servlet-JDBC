package com.sushant.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Define the fields username , password,
		
		String userName = "root";
		String password ="abc123ABC";
		String jdbcURL ="jdbc:mysql://localhost:3306/employeedirectory?useSSL=false";
		String driver ="com.mysql.cj.jdbc.Driver";
		
		//
		//2. Get PrintWriter Object
		PrintWriter writer = response.getWriter();
		writer.println("Connecting to Database"+jdbcURL);
		
		try {
			//3. Load the Driver
			Class.forName(driver);
			//4. Get The Connection
			Connection con= DriverManager.getConnection(jdbcURL,userName,password);
			writer.println("Connection Successful"+con);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//5 close the connection
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
