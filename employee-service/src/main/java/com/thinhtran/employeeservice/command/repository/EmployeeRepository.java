package com.thinhtran.employeeservice.command.repository;

import com.thinhtran.employeeservice.command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
