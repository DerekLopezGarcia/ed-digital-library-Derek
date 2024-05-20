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
class GetAllLoanUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private GetAllLoanUseCase getAllLoanUseCase;
    @BeforeEach
    void setUp() {
        getAllLoanUseCase = new GetAllLoanUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        getAllLoanUseCase = null;
    }
    @Test
    void verify_getAll() {
        getAllLoanUseCase.execute();
        verify(loanRepository, times(1)).getAll();
    }
}