package com.thinhtran.employeeservice.command.event;

import com.thinhtran.employeeservice.command.data.Employee;
import com.thinhtran.employeeservice.command.repository.EmployeeRepository;
import jakarta.ws.rs.NotFoundException;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeEventsHandler {

    @Autowired
    EmployeeRepository employeeRepository;

    @EventHandler
    public void on(CreateEmployeeEvent event){
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(UpdateEmployeeEvent event){
        Optional<Employee> existedEmployee = employeeRepository.findById(event.getId());
        Employee employee = existedEmployee.orElseThrow(() -> new NotFoundException("Employee not found"));
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setPhoneNumber(event.getPhoneNumber());
        employee.setIsDisciplined(event.getIsDisciplined());
        employeeRepository.save(employee);
    }
}
