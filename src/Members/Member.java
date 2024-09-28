package Members;

import Loan.Loan;
import Search.Searchable;

import java.util.ArrayList;
import java.util.UUID;

public class Member implements Searchable {
    protected String name;
    protected ArrayList<Loan> loans;
    protected MemberStatus memberStatus;
    protected final String memberId = UUID.randomUUID().toString();

    public Member(String name, MemberStatus memberStatus) {
        this.name = name;
        this.loans = new ArrayList<>();
        this.memberStatus = memberStatus;

    }


    public String getName() {
        return name;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nStatus: " + memberStatus;
    }

    @Override public boolean matchesSearch(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }
}
