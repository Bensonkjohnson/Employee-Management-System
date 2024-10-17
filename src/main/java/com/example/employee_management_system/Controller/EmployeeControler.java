package com.example.employee_management_system.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management_system.Entity.Employee;
import com.example.employee_management_system.Services.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {
    @Autowired
    private EmployeeServices employeeService;
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> listEmployees(
    		@RequestParam(required = false,defaultValue = "0") Integer page, @RequestParam(required = false,defaultValue = "10") Integer size) {
    	Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>( employeeService.listEmployees( pageable),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employee) {
        Employee emp= employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
         employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    
}
