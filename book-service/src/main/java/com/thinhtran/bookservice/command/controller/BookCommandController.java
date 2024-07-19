package com.thinhtran.bookservice.command.controller;

import com.thinhtran.bookservice.command.command.CreateBookCommand;
import com.thinhtran.bookservice.command.dto.CreateBookRequest;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createBook(@Valid @RequestBody CreateBookRequest request){
        CreateBookCommand command = new CreateBookCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getAuthor(),
                request.getStatus()
        );
        return commandGateway.sendAndWait(command);
    }
}
