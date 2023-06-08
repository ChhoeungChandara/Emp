package com.chandara.emp.service;


import java.util.List;

import com.chandara.emp.Entity.Employee;

public interface EmpService {
	Employee create(Employee employee);
	Employee getEmpId(Long id);
	List<Employee> getAll();
	Employee UpdateEmp(Long id,Employee emp);
	void deleteEmp(Long id);
}
