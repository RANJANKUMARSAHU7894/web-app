package com.rk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.EmployeeDao;
import com.rk.model.Employee;

@Service("empSer")
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> showEmployees() {
		return empDao.getAllEmployee();
	}

	@Override
	public String insertEmpDetails(Employee emp) {
		int employee = empDao.insertEmployee(emp);

		return employee == 0 ? "Register failed" : "Register Success";
	}

	@Override
	public Employee getByEmpno(int no) {
		Employee eno = empDao.getEmployeeByEno(no);
		return eno;
	}

	@Override
	public String updateEmp(Employee emp) {
		int updateEmpByno = empDao.updateEmpByno(emp);
		return updateEmpByno==0?"update not found":"found update and update succssfully";
	}

	@Override
	public String removeEmp(int no) {
		int deleteByEmpno = empDao.deleteByEmpno(no);
		return deleteByEmpno==0?"delete not found":"found and delete one record";
	}

}
