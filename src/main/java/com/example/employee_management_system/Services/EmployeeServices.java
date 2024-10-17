package com.example.employee_management_system.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.Entity.Employee;
import com.example.employee_management_system.Exception.EmployeeNotFoundException;
import com.example.employee_management_system.Repo.EmployeeRepo;

@Service
public class EmployeeServices {
	@Autowired
    private EmployeeRepo employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Page<Employee> listEmployees(Pageable peagable) {
        return employeeRepository.findAll(peagable);
    }

    public Employee updateEmployee(int id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
        	throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public ResponseEntity<String> deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
        	throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
