package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.employee.demo.repository")
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		log.info("Implementing findAll method for employee");
		return employeeRepository.findAll();
	}
	
	public Employee findById(int id) {
		log.info("Implementing find by Id method for employee");
		if(employeeRepository.findById(id).isPresent()) {
			return employeeRepository.findById(id).get();
		}
		return null;
	}
	
	public void save(Employee employee) {
		log.info("Implementing save method for employee");
		employeeRepository.save(employee);
	}
	
	public void delete(int id) {
		log.info("Implementing delete method for employee");
		Employee employee = findById(id);
		employeeRepository.delete(employee);
	}

}
