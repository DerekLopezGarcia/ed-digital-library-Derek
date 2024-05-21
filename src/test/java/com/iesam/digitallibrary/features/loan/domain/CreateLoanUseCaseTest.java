package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class CreateLoanUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private CreateLoanUseCase createLoanUseCase;
    @BeforeEach
    void setUp() {
        createLoanUseCase = new CreateLoanUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        createLoanUseCase = null;
    }
    @Test
    void recibounprestamoyloguardo() {
        Loan loan = new Loan("1", "1", "1", "2021-01-01", "2021-01-08", false);
        createLoanUseCase.execute(loan);
        verify(loanRepository).save(loan);
    }

}