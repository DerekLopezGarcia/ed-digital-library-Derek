package com.iesam.digitallibrary.features.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class GetAllBookUseCaseTest {
    @Mock
    BookRepsoitory bookRepsoitory;
    GetAllBookUseCase getAllBookUseCase;
    @BeforeEach
    void setUp() {
        getAllBookUseCase = new GetAllBookUseCase(bookRepsoitory);
    }

    @AfterEach
    void clear() {
        getAllBookUseCase = null;
    }
    @Test
    public void devuelvoTodosLosLibros() {
        Book book = new Book("title", "author", "123456","editorial",2021);
        when(bookRepsoitory.getAll()).thenReturn((ArrayList<Book>) List.of(book));
        List<Book> books = getAllBookUseCase.execute();
        assertEquals(books, List.of(book));
    }
}