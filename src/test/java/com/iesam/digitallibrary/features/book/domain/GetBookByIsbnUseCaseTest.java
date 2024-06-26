package com.iesam.digitallibrary.features.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetBookByIsbnUseCaseTest {
    @Mock
    BookRepsoitory bookRepsoitory;
    GetBookByIsbnUseCase getBookByIsbnUseCase;

    @BeforeEach
    void setUp() {
        getBookByIsbnUseCase = new GetBookByIsbnUseCase(bookRepsoitory);
    }

    @AfterEach
    void clear() {
        getBookByIsbnUseCase = null;
    }
    @Test
    public void recibounisbnylodevuelvo() {
        //given
        Book book = new Book("title", "author", "123456","editorial",2021);
        when(bookRepsoitory.get("123456")).thenReturn(book);
        //when
        Book bookReceived = getBookByIsbnUseCase.execute("123456");
        //then
        assertEquals(bookReceived.ISBN, "123456");
        assertEquals(bookReceived.author, "author");
        assertEquals(bookReceived.title, "title");
        assertEquals(bookReceived.editorial, "editorial");
        assertEquals(bookReceived.year, 2021);
        assertEquals(bookReceived, book);
    }
}