package com.thinhtran.bookservice.command.aggregate;

import com.thinhtran.bookservice.command.command.CreateBookCommand;
import com.thinhtran.bookservice.command.command.DeleteBookCommand;
import com.thinhtran.bookservice.command.command.UpdateBookCommand;
import com.thinhtran.bookservice.command.event.CreateBookEvent;
import com.thinhtran.bookservice.command.event.DeleteBookEvent;
import com.thinhtran.bookservice.command.event.UpdateBookEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
@Getter
@Setter
public class BookAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String author;

    private Boolean status;

    @CommandHandler
    public BookAggregate(CreateBookCommand command){
        CreateBookEvent createBookEvent = new CreateBookEvent();
        BeanUtils.copyProperties(command, createBookEvent);

        AggregateLifecycle.apply(createBookEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand command){
        UpdateBookEvent updateBookEvent = new UpdateBookEvent();
        BeanUtils.copyProperties(command, updateBookEvent);

        AggregateLifecycle.apply(updateBookEvent);
    }

    @CommandHandler
    public void handle(DeleteBookCommand command){
        DeleteBookEvent deleteBookEvent = new DeleteBookEvent();
        BeanUtils.copyProperties(command, deleteBookEvent);

        AggregateLifecycle.apply(deleteBookEvent);
    }

    @EventSourcingHandler
    public void on(CreateBookEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(UpdateBookEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.author = event.getAuthor();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(DeleteBookEvent event){
        this.id = event.getId();
    }
}
