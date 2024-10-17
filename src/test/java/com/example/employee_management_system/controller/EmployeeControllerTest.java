package com.example.employee_management_system.controller;



import com.example.employee_management_system.Controller.EmployeeControler;
import com.example.employee_management_system.Entity.Employee;
import com.example.employee_management_system.Services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeServices employeeService;

    @InjectMocks
    private EmployeeControler employeeController; // Fixed class name here

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee(1, "John Doe", 30, "Developer", 50000.0);
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testListEmployees() throws Exception {
        Employee employee = new Employee(1, "Jane Doe", 28, "Manager", 70000.0);
        Pageable pageable = PageRequest.of(0, 10);
        
        // Mock the Page<Employee> response
        Page<Employee> employeePage = new PageImpl<>(Arrays.asList(employee));

        when(employeeService.listEmployees(pageable)).thenReturn(employeePage);

        mockMvc.perform(get("/employees?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employees[0].name").value("Jane Doe")) // Adjusted for the response structure
                .andExpect(jsonPath("$.totalItems").value(1)); // Add assertions for pagination
    }
}