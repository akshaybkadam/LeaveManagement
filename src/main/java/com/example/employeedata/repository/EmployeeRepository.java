package com.example.employeedata.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.employeedata.model.EmployeeData;

public interface EmployeeRepository extends 
MongoRepository<EmployeeData,Integer>,
PagingAndSortingRepository<EmployeeData, Integer> 
{

	public EmployeeData findByEmpName(String name);
	public Page<EmployeeData> findAll(Pageable pageable);
	
}
