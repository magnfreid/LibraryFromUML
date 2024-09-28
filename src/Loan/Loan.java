package Loan;

import Medium.Medium.Medium;

public class Loan {
    final private int loanDate;
   private int returnDate;

    public Loan(Medium medium) {
        loanDate = 0;
    }

    public int getLoanDate() {
        return loanDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(int returnDate) {
        this.returnDate = returnDate;
    }
}
