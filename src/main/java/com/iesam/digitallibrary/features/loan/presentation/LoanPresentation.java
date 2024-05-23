package com.iesam.digitallibrary.features.loan.presentation;

import com.iesam.digitallibrary.features.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.features.loan.domain.*;

import java.util.ArrayList;

public class LoanPresentation {
    public static void createLoan(Loan loan) {
        CheckIfLoanPosibleUseCase checkIfLoanPosibleUseCase = new CheckIfLoanPosibleUseCase(LoanDataRepository.newInstance());
        checkIfLoanPosibleUseCase.execute(loan.getBookISBN());
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(LoanDataRepository.newInstance());
        createLoanUseCase.execute(loan);
    }
    public static void deleteLoan(String id) {
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(LoanDataRepository.newInstance());
        deleteLoanUseCase.execute(id);
    }
    public static Loan getLoan(String id) {
        GetLoanByIdUseCase getLoanByIdUseCase = new GetLoanByIdUseCase(LoanDataRepository.newInstance());
        return getLoanByIdUseCase.execute(id);
    }
    public static ArrayList<Loan> list() {
        GetAllLoanUseCase getAllLoanUseCase = new GetAllLoanUseCase(LoanDataRepository.newInstance());
        return getAllLoanUseCase.execute();
    }
    public static void updateLoan(Loan loan) {
        ModifyLoanByIdUseCase modifyLoanByIdUseCase = new ModifyLoanByIdUseCase(LoanDataRepository.newInstance());
        modifyLoanByIdUseCase.execute(loan);
    }
    public static ArrayList<Loan> listUnfinished() {
        GetUnfinishedLoansUseCase getUnfinishedLoansUseCase = new GetUnfinishedLoansUseCase(LoanDataRepository.newInstance());
        return getUnfinishedLoansUseCase.execute();
    }
    public static ArrayList<Loan> listFinished() {
        GetFinishedLoansUseCase getFinishedLoansUseCase = new GetFinishedLoansUseCase(LoanDataRepository.newInstance());
        return getFinishedLoansUseCase.execute();
    }
}
