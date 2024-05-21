package com.iesam.digitallibrary.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUnfinishedLoansUseCaseTest {
    @Mock
    private LoanRepository loanRepository;
    private GetUnfinishedLoansUseCase getUnfinishedLoansUseCase;
    @BeforeEach
    void setUp() {
        getUnfinishedLoansUseCase = new GetUnfinishedLoansUseCase(loanRepository);
    }

    @AfterEach
    void clear() {
        getUnfinishedLoansUseCase = null;
    }
    @Test
    void verifico_que_devuelva_solo_prestamos_no_devueltos() {
        // Arrange
        Loan loan1 = new Loan("1", "1", "1", "2021-01-01", "2021-01-08", false);
        Loan loan2 = new Loan("2", "2", "2", "2021-01-01", "2021-01-08", true);
        Loan loan3 = new Loan("3", "3", "3", "2021-01-01", "2021-01-08", false);
        loan1.setId("1");
        loan2.setId("2");
        loan3.setId("3");
        when(loanRepository.getAll()).thenReturn(new ArrayList<>(Arrays.asList(loan1, loan2, loan3)));
        // Act
        ArrayList<Loan> result = getUnfinishedLoansUseCase.execute();
        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(loan1));
        assertTrue(result.contains(loan3));
    }
}