package com.iesam.digitallibrary.features.loan.presentation;

import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.domain.*;

import java.util.ArrayList;

public class LoanPresentation {
    public void createLoan(Loan loan) {
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(LoanDataRepository.newInstance());
        createLoanUseCase.execute(loan);
    }
    public void deleteLoan(String id) {
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(LoanDataRepository.newInstance());
        deleteLoanUseCase.execute(id);
    }
    public Loan getLoan(String id) {
        GetLoanByIdUseCase getLoanByIdUseCase = new GetLoanByIdUseCase(LoanDataRepository.newInstance());
        return getLoanByIdUseCase.execute(id);
    }
    public ArrayList<Loan> execute() {
        GetAllLoanUseCase getAllLoanUseCase = new GetAllLoanUseCase(LoanDataRepository.newInstance());
        return getAllLoanUseCase.execute();
    }
    public void updateLoan(Loan loan) {
        ModifyLoanByIdUseCase modifyLoanByIdUseCase = new ModifyLoanByIdUseCase(LoanDataRepository.newInstance());
        modifyLoanByIdUseCase.execute(loan);
    }
}
