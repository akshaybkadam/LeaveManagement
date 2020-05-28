package com.example.employeedata.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.employeedata.model.EmployeeData;



public interface EmployeeRepository extends MongoRepository<EmployeeData,Integer>{

	public EmployeeData findByEmpName(String name);
}
