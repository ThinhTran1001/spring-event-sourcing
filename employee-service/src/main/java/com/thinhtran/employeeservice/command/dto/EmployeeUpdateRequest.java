package com.thinhtran.employeeservice.command.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {

    @NotNull(message = "first name is not null!")
    @NotBlank(message = "first name is mandatory!")
    private String firstName;

    @NotNull(message = "last name is not null!")
    @NotBlank(message = "last name is mandatory!")
    private String lastName;

    @NotNull(message = "phone number is not null!")
    @NotBlank(message = "phone number is mandatory!")
    private String phoneNumber;

    @NotNull(message = "is Disciplined is not null!")
    private Boolean isDisciplined;

}
