package com.example.employee_management_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@NotBlank(message = "Name is mandatory")
    private String name;
	@NotNull(message = "Age is mandatory")
	@Min(value = 18, message = "Age must be at least 18")
	@Max(value = 65, message = "Age must not exceed 65")
    private Integer age;
	@NotBlank(message = "Position is mandatory")
    private String position;
	@NotNull(message = "Salary is mandatory")
    @Positive(message = "Salary must be positive")
    private Double salary;
}
