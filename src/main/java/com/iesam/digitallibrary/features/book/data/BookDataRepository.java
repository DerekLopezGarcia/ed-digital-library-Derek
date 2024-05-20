package com.iesam.digitallibrary.features.book.data;

import com.iesam.digitallibrary.features.book.data.local.BookFileLocalDataSource;
import com.iesam.digitallibrary.features.book.domain.Book;
import com.iesam.digitallibrary.features.book.domain.BookRepsoitory;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookDataRepository implements BookRepsoitory {

    public BookFileLocalDataSource bookFileLocalDataSource = new BookFileLocalDataSource();
    public final Map<String, Book> bookMap = new HashMap<>();
    public final ArrayList<Book> users = new ArrayList<>();
    public static BookRepsoitory instance=null;
    public static BookDataRepository newInstance(){
        if(instance==null){
            instance=new BookDataRepository();
        }
        return (BookDataRepository) instance;
    }

    @Override
    public void save(Book book) {
        bookFileLocalDataSource.save(book);
    }

    @Override
    public void delete(String isbn) {
        bookFileLocalDataSource.delete(isbn);
    }

    @Override
    public Book get(String isbn) {
        return bookFileLocalDataSource.findById(isbn);
    }

    @Override
    public ArrayList<Book> getAll() {
        return bookFileLocalDataSource.findAll();
    }
}
