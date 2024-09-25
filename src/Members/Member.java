package Members;

import Library.Loan.Loan;
import Members.MemberStatus.MemberStatus;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Member {
    protected String name;
    protected MemberStatus memberStatus;
    protected ArrayList<Loan>loans;
    protected final String memberId = UUID.randomUUID().toString();

    public Member(String name, MemberStatus memberStatus) {
        this.name = name;
        this.memberStatus = memberStatus;

    }
}
