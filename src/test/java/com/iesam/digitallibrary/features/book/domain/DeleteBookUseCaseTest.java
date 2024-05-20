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
class DeleteBookUseCaseTest {
    @Mock
    BookRepsoitory bookRepsoitory;
    DeleteBookUseCase deleteBookUseCase;

    @BeforeEach
    void setUp() {
        deleteBookUseCase = new DeleteBookUseCase(bookRepsoitory);
    }

    @AfterEach
    void clear() {
        deleteBookUseCase = null;
    }
    @Test
    public void recibounisbnyborrolibro() {
        String isbn = "123456";
        deleteBookUseCase.execute(isbn);
        verify(bookRepsoitory, times(1)).delete(isbn);
    }
}