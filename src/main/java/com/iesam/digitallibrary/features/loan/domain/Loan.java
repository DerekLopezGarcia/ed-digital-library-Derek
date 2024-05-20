package com.iesam.digitallibrary.features.loan.domain;

public class Loan {
    protected String id;
    protected String bookISBN;
    protected String userDNI;
    protected String date;
    protected String returnDate;
    protected boolean returned;

    public Loan(String id, String bookISBN, String userDNI, String date, String returnDate, boolean returned) {
        this.id = id;
        this.bookISBN = bookISBN;
        this.userDNI = userDNI;
        this.date = date;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getUserDNI() {
        return userDNI;
    }

    public void setUserDNI(String userDNI) {
        this.userDNI = userDNI;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
