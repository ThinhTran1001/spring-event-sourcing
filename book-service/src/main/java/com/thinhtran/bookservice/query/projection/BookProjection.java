package com.thinhtran.bookservice.query.projection;

import com.thinhtran.bookservice.command.repository.BookRepository;
import com.thinhtran.bookservice.command.data.Book;
import com.thinhtran.bookservice.query.model.BookResponseModel;
import com.thinhtran.bookservice.query.queries.GetAllBookQuery;
import com.thinhtran.bookservice.query.queries.GetBookDetailQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBookQuery query){
        List<Book> list = bookRepository.findAll();
        List<BookResponseModel> bookResponseModelList = new ArrayList<>();
        list.forEach(book -> {
            BookResponseModel model = new BookResponseModel();
            BeanUtils.copyProperties(book, model);
            bookResponseModelList.add(model);
        });

        return bookResponseModelList;
    }

    @QueryHandler
    public BookResponseModel handle(GetBookDetailQuery query) throws Exception {
        BookResponseModel bookResponseModel = new BookResponseModel();

        Book book = bookRepository.findById(query.getId())
                .orElseThrow(() -> new Exception("Book not found!"));
        BeanUtils.copyProperties(book, bookResponseModel);

        return bookResponseModel;
    }
}
