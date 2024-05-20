package com.iesam.digitallibrary.features.loan.domain;

public class CreateLoanUseCase {
    private final LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        loanRepository.save(loan);
    }
}
