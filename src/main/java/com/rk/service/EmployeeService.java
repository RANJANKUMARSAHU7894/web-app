package com.rk.service;

import java.util.List;

import com.rk.model.Employee;

public interface EmployeeService {

	
	public List<Employee>  showEmployees();
	public String    insertEmpDetails(Employee emp);
	public Employee   getByEmpno(int no);
	public  String    updateEmp(Employee emp);
	public String   removeEmp(int no);
}
