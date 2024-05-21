package com.iesam.digitallibrary.features.loan.domain;

import com.iesam.digitallibrary.features.book.presentation.BookPresentation;
import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;

public class CheckIfLoanPosibleUseCase {
    private final LoanRepository loanRepository;

    public CheckIfLoanPosibleUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public boolean execute(String bookISBN) {
        // Check if the book is not already loaned
        GetAllLoanUseCase getAllLoanUseCase = new GetAllLoanUseCase(LoanDataRepository.newInstance());
        for (Loan loan : getAllLoanUseCase.execute()) {
            if (loan.getBookISBN().equals(bookISBN) && !loan.isReturned()) {
                return false;
            }
        }
        return true;
    }
}
