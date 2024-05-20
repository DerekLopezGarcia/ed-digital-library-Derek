package com.iesam.digitallibrary.features.book.domain;

public class SaveBookUseCase {

    private final BookRepsoitory bookRepsoitory;

    public SaveBookUseCase(BookRepsoitory bookRepsoitory) {
        this.bookRepsoitory = bookRepsoitory;
    }

    public void execute(Book book){
        bookRepsoitory.save(book);
    }
}
