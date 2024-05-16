package com.iesam.digitallibrary.features.book.presentation;

import com.iesam.digitallibrary.features.book.data.BookDataRepository;
import com.iesam.digitallibrary.features.book.domain.*;
import com.iesam.digitallibrary.features.user.domain.ModifyUserUseCase;
;import java.util.ArrayList;

public class BookPresentation {

    public static void saveBook(Book book){
        SaveBookUseCase saveBookUseCase = new SaveBookUseCase(BookDataRepository.newInstance());
        saveBookUseCase.execute(book);
    }
    public static void deleteBook(String isbn){
        DeleteBookUseCase deleteBookUseCase = new DeleteBookUseCase(BookDataRepository.newInstance());
        deleteBookUseCase.execute(isbn);
    }
    public static Book getBook(String isbn){
        GetBookByIsbnUseCase getBookByIsbnUseCase = new GetBookByIsbnUseCase(BookDataRepository.newInstance());
        return getBookByIsbnUseCase.execute(isbn);
    }
    public static void updateBook(Book book){
        ModifyBookUseCase modifyBookUseCase = new ModifyBookUseCase(BookDataRepository.newInstance());
        modifyBookUseCase.execute(book);
    }
    public static ArrayList<Book> getAllBooks(){
        GetAllBookUseCase getAllBookUseCase = new GetAllBookUseCase(BookDataRepository.newInstance());
        return getAllBookUseCase.execute();
    }

}
