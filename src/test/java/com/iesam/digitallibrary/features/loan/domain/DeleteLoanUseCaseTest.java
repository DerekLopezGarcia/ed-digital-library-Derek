package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteLoanUseCaseTest {
    @Mock
    private LoanRepository loanRepository;

    private DeleteLoanUseCase deleteLoanUseCase;
    @BeforeEach
    void setUp() {
        deleteLoanUseCase = new DeleteLoanUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        deleteLoanUseCase = null;
    }
    @Test
    void recibo_id_elimino_loan() {
        // Given
        String id = "1";
        // When
        deleteLoanUseCase.execute(id);
        // Then
        // Verify that the delete method of the loanRepository is called with the id
        verify(loanRepository).delete(id);
    }
}