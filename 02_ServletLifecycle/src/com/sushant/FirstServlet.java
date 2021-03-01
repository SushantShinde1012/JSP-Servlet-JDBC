package com.sushant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	

	public FirstServlet() {
		System.out.println("Inside the No-Arg Constructor");
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		PrintWriter writer= resp.getWriter();
		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		String fullName= firstName +" "+ lastName;
		writer.print(fullName);
		//req.setAttribute("name", fullName);
		//RequestDispatcher rd=req.getRequestDispatcher("/output.jsp");
		//rd.forward(req, resp);
		
	}
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Inside the init Method of Servlet");

	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("Inside Service Method of Servlet");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Inside The Destroy Method");
	}
	
	
}
