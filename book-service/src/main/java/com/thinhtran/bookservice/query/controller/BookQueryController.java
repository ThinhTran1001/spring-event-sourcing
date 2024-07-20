package com.thinhtran.bookservice.query.controller;

import com.thinhtran.bookservice.query.model.BookResponseModel;
import com.thinhtran.bookservice.query.queries.GetAllBookQuery;
import com.thinhtran.bookservice.query.queries.GetBookDetailQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/books")
public class BookQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<BookResponseModel> getAll(){
        GetAllBookQuery getAllBookQuery = new GetAllBookQuery();
        return queryGateway.query(
                getAllBookQuery,
                ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();
    }

    @GetMapping("/{bookId}")
    public BookResponseModel getBookDetail(@PathVariable String bookId){
        GetBookDetailQuery bookDetailQuery = new GetBookDetailQuery(bookId);
        return queryGateway.query(
                bookDetailQuery,
                ResponseTypes.instanceOf(BookResponseModel.class)).join();
    }
}
