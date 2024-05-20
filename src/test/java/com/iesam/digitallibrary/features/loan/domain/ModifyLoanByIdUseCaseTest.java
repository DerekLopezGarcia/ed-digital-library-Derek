package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ModifyLoanByIdUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private ModifyLoanByIdUseCase modifyLoanByIdUseCase;
    @BeforeEach
    void setUp() {
        modifyLoanByIdUseCase = new ModifyLoanByIdUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        modifyLoanByIdUseCase = null;
    }
    @Test
    void reciboUnPrestamoYLoModifico() {
        Loan loan = new Loan("1", "1", "1", "2021-01-01", "2021-01-08", false);
        modifyLoanByIdUseCase.execute(loan);
        verify(loanRepository, times(1)).delete(loan.getId());
        verify(loanRepository, times(1)).save(loan);
    }

}