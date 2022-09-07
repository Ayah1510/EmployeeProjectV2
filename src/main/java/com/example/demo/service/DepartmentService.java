package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.employee.demo.repository")
@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> findAll(){
		log.info("Implementing findAll method for department");
		return departmentRepository.findAll();
	}
	
	public Department findById(String name) {
		log.info("Implementing find by Id method for department");
		if(departmentRepository.findById(name).isPresent()) {
			return departmentRepository.findById(name).get();
		}
		return null;
	}

	public void save(Department department) {
		log.info("Implementing save method for department");
		departmentRepository.save(department);
	}
	
	public void delete(String name) {
		log.info("Implementing delete method for department");
		Department department = findById(name);
		departmentRepository.delete(department);
	}
}
