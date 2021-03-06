package com.example.employeedata.resource;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedata.EmployeeDataApplication;
import com.example.employeedata.model.EmployeeData;
import com.example.employeedata.repository.EmployeeRepository;
import lombok.*;
@RestController

	 
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
//	Logger logger = LogManager.getLogger(EmployeeDataApplication.class);
	
	
	@PostMapping("/addEmployee")
	
	public String saveEmployee(@RequestBody EmployeeData employeedata) {
		repository.save(employeedata);
		return "Added Employee with ID: "+employeedata.getId();
		
	}
	
	@GetMapping ("/findById/{id}")
	public Optional<EmployeeData> getEmployee(@PathVariable int id) {
		return repository.findById(id);
	}
	
	
	
	@GetMapping("/all")
    public List<EmployeeData> getAll() {
        return repository.findAll();
    }
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted:  "+ id;
	}

	@GetMapping("/byName/{empName}")
	public EmployeeData getEmployeeName(@PathVariable String empName) {
		return repository.findByEmpName(empName);
	}
	
	
	@PutMapping("/update/{empName}")
    public EmployeeData updateDept(@RequestBody EmployeeData employeedata, @PathVariable String empName) {
		EmployeeData ed = repository.findByEmpName(empName);
		ed.setId(employeedata.getId());
		ed.setCompName(employeedata.getCompName());
		ed.setEmpName(employeedata.getEmpName());
		repository.save(ed);
        return ed;
    }
	
	@GetMapping("/PaginationSort")
	public Page<EmployeeData> fetchPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	
	
	
	
}
