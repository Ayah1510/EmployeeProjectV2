package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.employee.demo.repository")
@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> findAll(){
		log.info("Implementing findAll method for employee");
		return taskRepository.findAll();
	}
	
	public Task findById(String name) {
		log.info("Implementing find by Id method for employee");
		if(taskRepository.findById(name).isPresent()) {
			return taskRepository.findById(name).get();
		}
		return null;
	}
	
	public void save(Task task) {
		log.info("Implementing save method for employee");
		taskRepository.save(task);
	}
	
	public void delete(String name) {
		log.info("Implementing delete method for employee");
		Task task = findById(name);
		taskRepository.delete(task);
	}

}
