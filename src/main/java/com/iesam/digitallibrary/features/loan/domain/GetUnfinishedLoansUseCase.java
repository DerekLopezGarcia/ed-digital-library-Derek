package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public class GetUnfinishedLoansUseCase {
    private final LoanRepository loanRepository;

    public GetUnfinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public ArrayList<Loan> execute() {
        ArrayList<Loan> loans = loanRepository.getAll();
        ArrayList<Loan> unfinishedLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (!loan.returned == true) {
                unfinishedLoans.add(loan);
            }
        }
        return unfinishedLoans;
    }
}
