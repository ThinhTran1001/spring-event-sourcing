package com.thinhtran.employeeservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeEvent {

    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean isDisciplined;
}
