package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetLoanByIdUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private GetLoanByIdUseCase getLoanByIdUseCase;
    @BeforeEach
    void setUp() {
        getLoanByIdUseCase = new GetLoanByIdUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        getLoanByIdUseCase = null;
    }
    @Test
    void recibo_id_devuelvo_loan() {
        // Arrange
        String id = "1";
        Loan loan = new Loan("1", "1", "1", "2021-01-01", "2021-01-08", false);
        loan.setId(id);
        when(loanRepository.get(id)).thenReturn(loan);
        // Act
        Loan result = getLoanByIdUseCase.execute(id);
        // Assert
        assertEquals(loan, result);
    }
}