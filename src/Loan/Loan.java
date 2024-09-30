package Loan;

import Medium.Medium.Medium;

public class Loan {
   private Medium medium;

    public Loan(Medium medium) {
        this.medium = medium;

    }




    @Override
    public String toString() {
        return "Loan: " + medium;
    }
}
