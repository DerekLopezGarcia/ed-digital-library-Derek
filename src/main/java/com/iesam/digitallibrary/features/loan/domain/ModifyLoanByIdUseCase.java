package com.iesam.digitallibrary.features.loan.domain;

public class ModifyLoanByIdUseCase {
    private final LoanRepository loanRepository;

    public ModifyLoanByIdUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        loanRepository.delete(loan.getId());
        loanRepository.save(loan);
    }
}
