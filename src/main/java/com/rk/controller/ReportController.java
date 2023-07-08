package com.rk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rk.model.Employee;
import com.rk.service.EmployeeService;

@Controller
public class ReportController {

	@Autowired
	private EmployeeService empSer;

	@GetMapping("/")
	public String showReport() {
		return "home";
	}

	@GetMapping("/report")
	public String showAllEmployees(Map<String, Object> map) {

		List<Employee> list = empSer.showEmployees();

		map.put("empList", list);

		return "report";

	}

	@GetMapping("/add_employee")
	public String addRegisterEmployee(@ModelAttribute("employee") Employee employee) {

		return "register";
	}

	@PostMapping("/add_employee")
	public String addEmployee(@ModelAttribute("employee") Employee employee, Map<String, Object> map) {

		String details = empSer.insertEmpDetails(employee);
		List<Employee> list = empSer.showEmployees();

		map.put("msg", details);
		map.put("empList", list);

		return "report";
	}

	@GetMapping("/edit_employee")
	public String getByEno(@RequestParam("no") int no, @ModelAttribute("employee") Employee employee) {
		Employee byEmpno = empSer.getByEmpno(no);

		BeanUtils.copyProperties(byEmpno, employee);
		return "edit";
	}

	@PostMapping("/edit_employee")
	public String updateByEno(@ModelAttribute("employee") Employee employee, Map<String, Object> map) {
		String details = empSer.updateEmp(employee);
		List<Employee> list = empSer.showEmployees();
		map.put("msg", details);
		map.put("empList", list);
		return "report";
	}

	@GetMapping("/delete_employee")
	public String deleteByEno(@RequestParam("no") int no, @ModelAttribute("employee") Employee employee,
			Map<String, Object> map) {
		String details = empSer.removeEmp(no);
		List<Employee> list = empSer.showEmployees();
		map.put("msg", details);
		map.put("empList", list);
		return "report";
	}

}
