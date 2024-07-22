package com.thinhtran.employeeservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeCommand {

    @TargetAggregateIdentifier
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean isDisciplined;

}
