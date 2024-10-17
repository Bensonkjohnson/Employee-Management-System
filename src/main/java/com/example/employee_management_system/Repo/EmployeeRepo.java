package com.example.employee_management_system.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_management_system.Entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
