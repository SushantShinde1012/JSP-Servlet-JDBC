package com.sushant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Serving Request from doGet Method of Servlet ");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String fullName = firstName +" "+ lastName;
		out.print("Your Full Name is : "+fullName);
		//resp.sendRedirect("https://sushantshinde1012.github.io");
		//resp.sendRedirect("test.html");
		req.setAttribute("name", fullName);
		RequestDispatcher rd= req.getRequestDispatcher("/output.jsp");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Serving Request from doPost method of Servlet ");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String fullName = firstName +" "+ lastName;
		out.print("Your Full Name is : "+fullName);
	}

}
