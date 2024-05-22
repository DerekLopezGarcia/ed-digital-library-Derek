package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetFinishedLoansUseCase {
    private final LoanRepository loanRepository;

    public GetFinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public ArrayList<Loan> execute() {
        ArrayList<Loan> finishedLoans = new ArrayList<>();
        for (Loan loan : loanRepository.getAll()) {
            if (loan.returned == true) {
                finishedLoans.add(loan);
            }
        }return finishedLoans;
    }
}
