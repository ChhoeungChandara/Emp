package com.chandara.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandara.emp.Entity.Employee;
import com.chandara.emp.service.EmpService;

@RestController
@RequestMapping("em")
public class EmpController {
	@Autowired
	private EmpService empService;
	@PostMapping
	public ResponseEntity<?> saveEmp(@RequestBody Employee employee){
		return ResponseEntity.ok(employee = empService.create(employee));

	}
	@GetMapping("{id}")
	public ResponseEntity<?> getEmpById(@PathVariable("id") Long id){
		Employee empid = empService.getEmpId(id);
		return ResponseEntity.ok(empid);

	}
	@GetMapping
	public ResponseEntity<?> getAllEmp(){
		List<Employee> employee = empService.getAll();
		return ResponseEntity.ok(employee);

	}
	@PutMapping("{id}")
	public ResponseEntity<?> Update(@PathVariable("id") Long id,@RequestBody Employee emp){
		
		Employee employee = empService.UpdateEmp(id,emp);
		return ResponseEntity.ok(employee);

	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		  empService.deleteEmp(id);
		  return ResponseEntity.ok("delete success");
	}


	

}
