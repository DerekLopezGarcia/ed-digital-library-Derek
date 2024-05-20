package com.iesam.digitallibrary.features.book.domain;

public class DeleteBookUseCase {

    private final BookRepsoitory bookRepsoitory;

    public DeleteBookUseCase(BookRepsoitory bookRepsoitory) {
        this.bookRepsoitory = bookRepsoitory;
    }

    public void execute(String isbn){
        bookRepsoitory.delete(isbn);
    }
}
