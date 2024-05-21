package com.iesam.digitallibrary.features.loan.domain;

public class GetLoanByIdUseCase {
    private final LoanRepository loanRepository;

    public GetLoanByIdUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute(String id) {
        return loanRepository.get(id);
    }
}
