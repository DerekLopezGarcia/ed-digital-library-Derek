package com.iesam.digitallibrary.features.book.domain;

import java.util.ArrayList;

public interface BookRepsoitory {
    void save(Book book);
    void delete(String isbn);
    Book get(String isbn);
    ArrayList<Book> getAll();
}
