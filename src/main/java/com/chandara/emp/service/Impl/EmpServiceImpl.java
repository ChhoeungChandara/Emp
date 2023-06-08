package com.chandara.emp.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chandara.emp.Entity.Employee;
import com.chandara.emp.Repository.EmployeeRepository;
import com.chandara.emp.exception.ResourceNotFoundException;
import com.chandara.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmpId(Long id) {
		return employeeRepository.findById(id)
				            .orElseThrow(()-> new ResourceNotFoundException("employee not exit has id"+ id));
		
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll() ;
	}

	@Override
	public Employee UpdateEmp(Long id, Employee emp) {
		Employee exitEmp = employeeRepository.findById(id)
				           .orElseThrow(()-> new ResourceNotFoundException("Employee with id = %d not found"+id));
		exitEmp.setFirstName(emp.getFirstName());
		exitEmp.setLastName(emp.getLastName());
		exitEmp.setEmail(emp.getEmail());
		return employeeRepository.save(exitEmp);
	}

	@Override
	public void deleteEmp(Long id) {
		Employee exitEmployee = employeeRepository.findById(id)
		           .orElseThrow(()-> new ResourceNotFoundException("Employee with id = %d not found"+id));
		employeeRepository.delete(exitEmployee);
	}

	

}
