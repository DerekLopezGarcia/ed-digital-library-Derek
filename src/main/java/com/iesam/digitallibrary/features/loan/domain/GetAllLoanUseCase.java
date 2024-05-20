package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetAllLoanUseCase {
    private final LoanRepository loanRepository;

    public GetAllLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public ArrayList<Loan> execute() {
        return loanRepository.getAll();
    }
}
