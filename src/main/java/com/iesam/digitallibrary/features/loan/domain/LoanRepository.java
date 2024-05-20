package com.iesam.digitallibrary.features.loan.domain;

import java.util.ArrayList;

public interface LoanRepository {
    void save(Loan loan);
    void delete(String id);
    Loan get(String id);
    ArrayList<Loan> getAll();
}
