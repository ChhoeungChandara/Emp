package com.chandara.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandara.emp.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
