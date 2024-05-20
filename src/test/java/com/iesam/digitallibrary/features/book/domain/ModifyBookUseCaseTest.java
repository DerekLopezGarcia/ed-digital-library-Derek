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
class ModifyBookUseCaseTest {
    @Mock
    BookRepsoitory bookRepsoitory;
    ModifyBookUseCase modifyBookUseCase;
    @BeforeEach
        void setUp() {
        modifyBookUseCase = new ModifyBookUseCase(bookRepsoitory);
    }

    @AfterEach
    void clear() {
        modifyBookUseCase = null;
    }
    @Test
    public void recibounlibroylomodifico() {
        Book book = new Book("title", "author", "123456","editorial",2021);
        modifyBookUseCase.execute(book);
        verify(bookRepsoitory, times(1)).delete(book.getISBN());
        verify(bookRepsoitory, times(1)).save(book);
    }
}