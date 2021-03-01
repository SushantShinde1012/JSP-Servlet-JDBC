package com.sushant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter writer =resp.getWriter();
		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		String fullName=firstName+" "+lastName;
		
		List <Student> l1=new ArrayList<Student>();
		
		Student s1=new Student();
		s1.setName("Kaweri Phad");
		s1.setAge(25);
		s1.setLocation("Pune");
		
		
		//writer.println(fullName);
		
		Student s2=new Student();
		s2.setName("Sushant");
		s2.setAge(25);
		s2.setLocation("Latur");
		
		l1.add(s1);
		l1.add(s2);
		
		String [] countries = {"India", "Sri Lanka","Japan","US","United Kingdom"};
		
		//req.setAttribute("student", s1);
		//req.setAttribute("name",fullName);
		req.setAttribute("studentList", l1);
		req.setAttribute("countries", countries);
		RequestDispatcher rd= req.getRequestDispatcher("/JSTLDemo.jsp");
		rd.forward(req, resp);
	}

}
