package com.sushant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sushant.pojo.Employee;
import com.sushant.util.DBConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	Connection connection =null;
	Statement statement =null;
	ResultSet resultSet=null;
	
	PreparedStatement pst=null;
	
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		
		List <Employee> list=null;
		Employee employee = null;
		try {
			
			
			list=new ArrayList<Employee>();
			String query ="SELECT * FROM tbl_employee";
			 connection =DBConnectionUtil.openConnection();
			 statement =connection.createStatement();
			 resultSet=statement.executeQuery(query);
			 System.out.println(resultSet);
			while(resultSet.next()) {
				
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));
				list.add(employee);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean save(Employee e) {
		// TODO Auto-generated method stub
		System.out.println("Employee:  "+e);
		boolean flag=false;
		
		try {
			String sqlQuery="INSERT INTO tbl_employee(name,dob,department)VALUES('"+e.getName()+"','"+e.getDob()+"','"+e.getDepartment()+"')";
			connection=DBConnectionUtil.openConnection();
			pst =connection.prepareStatement(sqlQuery);
			pst.executeUpdate();
			flag=true;
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		Employee e1=null;
		try {
			e1=new Employee();
			String sqlQuery="SELECT * FROM tbl_employee where id="+id;
			connection=DBConnectionUtil.openConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				e1.setId(resultSet.getInt("id"));
				e1.setName(resultSet.getString("name"));
				e1.setDepartment(resultSet.getString("department"));
				e1.setDob(resultSet.getString("dob"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(e1);
		return e1;
	}

	@Override
	public boolean update(Employee e) {
		boolean flag=false;
		
		try {
			String sqlQuery="UPDATE tbl_employee SET name='"+e.getName()+"', dob='"+e.getDob()+"', department='"+e.getDepartment()+"' where id="+e.getId();
			connection=DBConnectionUtil.openConnection();
			pst=connection.prepareStatement(sqlQuery);
			pst.executeUpdate();
			flag=true;
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sqlQuery="DELETE FROM tbl_employee where id="+id;
			connection=DBConnectionUtil.openConnection();
			pst=connection.prepareStatement(sqlQuery);
			pst.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
