package com.rk.dao;

import java.util.List;

import com.rk.model.Employee;

public interface EmployeeDao {
	
	
	public List<Employee>  getAllEmployee();
		
	public int   insertEmployee(Employee emp);
	
	public Employee getEmployeeByEno(int no);
	
	public int   updateEmpByno(Employee emp);
	
	
	public int deleteByEmpno(int no);

}
