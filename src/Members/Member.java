package Members;

import Loan.Loan;
import Search.Searchable;

import java.util.ArrayList;

public class Member implements Searchable {
    protected String name;
    protected ArrayList<Loan> loans;
    protected MemberStatus memberStatus;
    protected final String id;

    public Member(String name, MemberStatus memberStatus, String id) {
        this.name = name;
        this.id = id;
        this.loans = new ArrayList<>();
        this.memberStatus = memberStatus;

    }


    public String getName() {
        return name;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public String getId() {
        return id;
    }

    public void printLoans(){
        System.out.println(name + " current loans:");
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }



    @Override
    public String toString() {
        return "Name: " + name +
                "\nStatus: " + memberStatus +
                "\nID: " + id;
    }

    @Override public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }
}
