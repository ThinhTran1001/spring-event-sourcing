package com.thinhtran.bookservice.command;

import com.thinhtran.bookservice.command.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
