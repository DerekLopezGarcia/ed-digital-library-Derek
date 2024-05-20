package com.iesam.digitallibrary.features.loan.data;

import com.iesam.digitallibrary.features.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.features.loan.domain.Loan;
import com.iesam.digitallibrary.features.loan.domain.LoanRepository;
import com.iesam.digitallibrary.features.user.data.UserDataRepository;
import com.iesam.digitallibrary.features.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoanDataRepository implements LoanRepository {
    public LoanFileLocalDataSource loanFileLocalDataSource = new LoanFileLocalDataSource();
    public final Map<String, Loan> loanMap = new HashMap<>();
    public final ArrayList<Loan> loans = new ArrayList<>();
    public static UserRepository instance=null;
    public static LoanDataRepository newInstance(){
        if(instance==null){
            instance=new UserDataRepository();
        }
        return (LoanDataRepository) instance;
    }

    @Override
    public void save(Loan loan) {
        loanFileLocalDataSource.save(loan);
    }

    @Override
    public void delete(String id) {
        loanFileLocalDataSource.delete(id);
    }

    @Override
    public Loan get(String id) {
        return loanFileLocalDataSource.findById(id);
    }

    @Override
    public ArrayList<Loan> getAll() {
        return loanFileLocalDataSource.findAll();
    }
}
