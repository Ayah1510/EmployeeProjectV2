package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.employee.demo.repository")
@Service
public class ProjectService {


	@Autowired
	ProjectRepository projectRepository;
	
	public List<Project> findAll(){
		log.info("Implementing findAll method for employee");
		return projectRepository.findAll();
	}
	
	public Project findById(String name) {
		log.info("Implementing find by Id method for employee");
		if(projectRepository.findById(name).isPresent()) {
			return projectRepository.findById(name).get();
		}
		return null;
	}
	
	public void save(Project project) {
		log.info("Implementing save method for employee");
		projectRepository.save(project);
	}
	
	public void delete(String name) {
		log.info("Implementing delete method for employee");
		Project project = findById(name);
		projectRepository.delete(project);
	}

}
