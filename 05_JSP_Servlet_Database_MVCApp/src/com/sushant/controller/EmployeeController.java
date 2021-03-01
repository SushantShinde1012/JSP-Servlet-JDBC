package com.sushant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushant.dao.EmployeeDao;
import com.sushant.dao.EmployeeDaoImpl;
import com.sushant.pojo.Employee;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    EmployeeDao dao = null;
    RequestDispatcher rd=null;
   
   
    public EmployeeController() {
        super();
        dao=new EmployeeDaoImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action==null) {
			action="LIST";
			
		}
		switch(action) {
		case "LIST":
			ListEmployees(request,response);
			break;
		case "EDIT":
			getSingleEmployee(request,response);
			break;
		case "DELETE":
			deleteEmployee(request,response);
			break;
		default:
			ListEmployees(request,response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		String id=request.getParameter("id");
		String firstName=request.getParameter("fname");
		String dateOfBirth=request.getParameter("dob");
		String department=request.getParameter("department");
		
		//System.out.println("id"+id+"firstName"+firstName+"date of birth"+dateOfBirth+"department"+department);
		//writer.println("Data Entered :"+firstName+" "+dateOfBirth+" "+department);
		Employee e=new Employee();
		
		e.setName(firstName);
		e.setDob(dateOfBirth);
		e.setDepartment(department);
		
		if(id.isEmpty() || id == null) {
			//save
						if(dao.save(e)){
							request.setAttribute("message","Record Saved Successfully...!");
							ListEmployees(request,response);
				
						}else {
							request.setAttribute("message","Unable to Save");
							ListEmployees(request,response);
				
						}
			
		}else {
		
					e.setId(Integer.parseInt(id));
						if(dao.update(e)){
			
							request.setAttribute("message","Record Updated Successfully...!");
							ListEmployees(request,response);
			
						}else {
							request.setAttribute("message","Unable to Update");
							ListEmployees(request,response);
			
						}
			}
		
		
		
	}
	public void ListEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<Employee> e1 = dao.get();
		 req.setAttribute("listEmployee", e1);
		 rd=req.getRequestDispatcher("/views/employee-list.jsp");
		rd.forward(req, resp);

	}
	
	public void getSingleEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 PrintWriter writer=resp.getWriter();
		String empId= req.getParameter("id");
		writer.print(empId);
		Employee employee=dao.get(Integer.parseInt(empId));
		req.setAttribute("employee",employee);
		rd=req.getRequestDispatcher("/views/employee-add.jsp");
		rd.forward(req, resp);
		
	}
	public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 PrintWriter writer=resp.getWriter();
			String empId= req.getParameter("id");
			writer.print(empId);
			boolean flag=dao.delete(Integer.parseInt(empId));
			if(flag){
				req.setAttribute("message","Record Deleted Successfully...!");
				ListEmployees(req,resp);
	
			}else {
				req.setAttribute("message","Unable to Delete");
				ListEmployees(req,resp);
	
			}
	}

}
