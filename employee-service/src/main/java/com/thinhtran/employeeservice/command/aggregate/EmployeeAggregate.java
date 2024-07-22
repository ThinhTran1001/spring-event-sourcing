package com.thinhtran.employeeservice.command.aggregate;

import com.thinhtran.employeeservice.command.command.CreateEmployeeCommand;
import com.thinhtran.employeeservice.command.command.UpdateEmployeeCommand;
import com.thinhtran.employeeservice.command.event.CreateEmployeeEvent;
import com.thinhtran.employeeservice.command.event.UpdateEmployeeEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Aggregate
public class EmployeeAggregate {

    @AggregateIdentifier
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Boolean isDisciplined;

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command){
        CreateEmployeeEvent event = new CreateEmployeeEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command){
        UpdateEmployeeEvent event = new UpdateEmployeeEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateEmployeeEvent event){
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.phoneNumber = event.getPhoneNumber();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(UpdateEmployeeEvent event){
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.phoneNumber = event.getPhoneNumber();
        this.isDisciplined = event.getIsDisciplined();
    }

}
