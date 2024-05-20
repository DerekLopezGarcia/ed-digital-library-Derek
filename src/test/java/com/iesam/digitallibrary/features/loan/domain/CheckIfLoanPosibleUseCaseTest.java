package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckIfLoanPosibleUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private CheckIfLoanPosibleUseCase checkIfLoanPosibleUseCase;

    @BeforeEach
    void setUp() {
        checkIfLoanPosibleUseCase = new CheckIfLoanPosibleUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        checkIfLoanPosibleUseCase = null;
    }
    @Test
    void recibo_un_ISBN_de_un_libro_y_devuelvo_true_si_no_esta_prestado() {
        // Arrange
        String bookISBN = "1234567890123";
        // Act
        boolean result = checkIfLoanPosibleUseCase.execute(bookISBN);
        // Assert
        assertTrue(result);
    }
}