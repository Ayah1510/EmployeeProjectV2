package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@EnableJpaRepositories(basePackages = {"com.example.demo"})
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

}
