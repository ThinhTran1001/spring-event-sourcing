package com.thinhtran.employeeservice.command.controller;

import com.thinhtran.employeeservice.command.command.CreateEmployeeCommand;
import com.thinhtran.employeeservice.command.command.UpdateEmployeeCommand;
import com.thinhtran.employeeservice.command.dto.EmployeeCreateRequest;
import com.thinhtran.employeeservice.command.dto.EmployeeUpdateRequest;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createEmployee(@Valid @RequestBody EmployeeCreateRequest request){
        CreateEmployeeCommand command = new CreateEmployeeCommand(
                UUID.randomUUID().toString(),
                request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                false);

        return commandGateway.sendAndWait(command);
    }

    @PutMapping("/{employeeId}")
    public String update(
            @Valid @RequestBody EmployeeUpdateRequest request,
            @PathVariable String employeeId){
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(
                employeeId,
                request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                request.getIsDisciplined());

        return commandGateway.sendAndWait(command);
    }

}
