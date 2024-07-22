package com.thinhtran.employeeservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeEvent {

    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean isDisciplined;

}
