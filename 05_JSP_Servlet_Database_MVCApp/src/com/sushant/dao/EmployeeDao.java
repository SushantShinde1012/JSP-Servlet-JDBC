package com.sushant.dao;

import java.util.List;

import com.sushant.pojo.Employee;

public interface EmployeeDao {
	
	//DAO - Data Accessor Object
	List <Employee> get();
	boolean save(Employee e);
	Employee get(int id);
	boolean update(Employee e);
	boolean delete(int id);

}
