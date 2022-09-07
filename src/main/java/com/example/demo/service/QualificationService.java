package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Qualification;
import com.example.demo.repository.QualificationRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ComponentScan("com.employee.demo.repository")
@Service
public class QualificationService {

	@Autowired
	QualificationRepository qualificationRepository;
	
	public List<Qualification> findAll(){
		log.info("Implementing findAll method for employee");
		return qualificationRepository.findAll();
	}
	
	public Qualification findById(String name) {
		log.info("Implementing find by Id method for employee");
		if(qualificationRepository.findById(name).isPresent()) {
			return qualificationRepository.findById(name).get();
		}
		return null;
	}
	
	public void delete(String name) {
		log.info("Implementing delete method for employee");
		Qualification qualification = findById(name);
		qualificationRepository.delete(qualification);
	}
	
	public void save(Qualification qualification) {
		log.info("Implementing save method for employee");
		qualificationRepository.save(qualification);
	}

}
