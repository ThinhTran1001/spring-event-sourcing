package com.thinhtran.bookservice.command.event;

import com.thinhtran.bookservice.command.BookRepository;
import com.thinhtran.bookservice.command.data.Book;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @EventHandler
    public void on(UpdateBookEvent event){
        Optional<Book> existedBook = bookRepository.findById(event.getId());

        if(existedBook.isPresent()){
            Book book = existedBook.get();
            book.setName(event.getName());
            book.setAuthor(event.getAuthor());
            book.setStatus(event.getStatus());

            bookRepository.save(book);
        }
    }

    @EventHandler
    public void on(DeleteBookEvent event){
        Optional<Book> existedBook = bookRepository.findById(event.getId());

        existedBook.ifPresent(book -> bookRepository.delete(book));
    }
}
