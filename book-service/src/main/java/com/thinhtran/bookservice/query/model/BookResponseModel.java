package com.thinhtran.bookservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseModel {

    private String id;

    private String name;

    private String author;

    private Boolean status;

}

