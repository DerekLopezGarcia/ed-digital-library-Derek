package com.iesam.digitallibrary.features.book.domain;

import java.util.ArrayList;

public class GetAllBookUseCase {

    private final BookRepsoitory bookRepsoitory;

    public GetAllBookUseCase(BookRepsoitory bookRepsoitory) {
        this.bookRepsoitory = bookRepsoitory;
    }

    public ArrayList<Book> execute(){
        return bookRepsoitory.getAll();
    }
}
