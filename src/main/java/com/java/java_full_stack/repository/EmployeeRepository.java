package com.java.java_full_stack.repository;

import com.java.java_full_stack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
     Optional<Employee> findByEmail(String email);

}
