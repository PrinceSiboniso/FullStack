package com.java.java_full_stack.service;

import com.java.java_full_stack.exception.EmployeeAlreadyExistException;
import com.java.java_full_stack.exception.EmployeeNotFoundException;
import com.java.java_full_stack.model.Employee;
import com.java.java_full_stack.repository.EmployeeRepository;

import com.java.java_full_stack.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee addEmployee(Employee employee) {
        if ( employeeAlreadyExists (employee.getEmail())){
            throw  new EmployeeAlreadyExistException(employee.getEmail()+"already exixt !");

        }

        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return employeeRepository.findById(id).map( st -> {

            st.setFirstName(employee.getFirstName());
            st.setLastName(employee.getLastName());
            st.setEmail(employee.getEmail());
            st.setDepartment(employee.getDepartment());
            return employeeRepository.save(st);

        }).orElseThrow(() -> new EmployeeNotFoundException("Sorry , this employee is not found"));
    }

    @Override
    public Employee getEmployeeId(Long id) {
        return employeeRepository.findById(id).
                orElseThrow(() -> new EmployeeNotFoundException("Sorry no Employee found with this id not :"+id));
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw  new EmployeeNotFoundException("sorry this employee not found ");
        }

    }
    private boolean employeeAlreadyExists(String email){
        return employeeRepository.findByEmail(email).isPresent();

    }


}

