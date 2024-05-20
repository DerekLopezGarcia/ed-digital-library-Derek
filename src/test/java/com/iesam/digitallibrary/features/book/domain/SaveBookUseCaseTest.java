package com.iesam.digitallibrary.features.book.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class SaveBookUseCaseTest {
    @Mock
    BookRepsoitory bookRepsoitory;
    SaveBookUseCase saveBookUseCase;

    @BeforeEach
    void setUp() {
        saveBookUseCase = new SaveBookUseCase(bookRepsoitory);
    }

    @AfterEach
    void clear() {
        saveBookUseCase = null;
    }
    @Test
    public void recibounlibroyloguardo() {
        Book book = new Book("title", "author", "123456","editorial",2021);
        saveBookUseCase.execute(book);
        verify(bookRepsoitory, times(1)).save(book);
    }
}