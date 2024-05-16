package com.iesam.digitallibrary.features.book.domain;

public class GetBookByIsbnUseCase {

    private final BookRepsoitory bookRepsoitory;

    public GetBookByIsbnUseCase(BookRepsoitory bookRepsoitory) {
        this.bookRepsoitory = bookRepsoitory;
    }

    public Book execute(String isbn){
        return bookRepsoitory.get(isbn);
    }
}
