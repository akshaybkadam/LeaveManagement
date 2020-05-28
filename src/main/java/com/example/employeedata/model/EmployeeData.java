package com.example.employeedata.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;


@Document(collection = "DemoData")

public class EmployeeData {

	
	private Integer id;
	private String empName;
	private String compName;
	
	EmployeeData(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	
}


