package com.thinhtran.employeeservice.command.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean isDisciplined;
}
