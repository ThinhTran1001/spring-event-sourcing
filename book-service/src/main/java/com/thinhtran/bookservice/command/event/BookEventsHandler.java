package com.thinhtran.bookservice.command.event;

import com.thinhtran.bookservice.command.BookRepository;
import com.thinhtran.bookservice.command.data.Book;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {

    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    public void on(CreateBookEvent event){
        Book book = new Book();
        BeanUtils.copyProperties(event, book);

        bookRepository.save(book);
    }
}
