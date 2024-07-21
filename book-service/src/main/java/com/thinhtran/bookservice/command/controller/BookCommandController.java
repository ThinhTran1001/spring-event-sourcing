package com.thinhtran.bookservice.command.controller;

import com.thinhtran.bookservice.command.command.CreateBookCommand;
import com.thinhtran.bookservice.command.command.DeleteBookCommand;
import com.thinhtran.bookservice.command.command.UpdateBookCommand;
import com.thinhtran.bookservice.command.dto.BookModelRequest;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createBook(@Valid @RequestBody BookModelRequest request){
        CreateBookCommand command = new CreateBookCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getAuthor(),
                true);
        return commandGateway.sendAndWait(command);
    }

    @PutMapping("/{bookId}")
    public String updateBook(
            @Valid @RequestBody BookModelRequest request,
            @PathVariable String bookId){
        UpdateBookCommand command = new UpdateBookCommand(
                bookId,
                request.getName(),
                request.getAuthor(),
                request.getStatus());
        return commandGateway.sendAndWait(command);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        DeleteBookCommand command = new DeleteBookCommand(bookId);

        return commandGateway.sendAndWait(command);
    }

}
