package Members.MemberStatus;

public class RegularMember implements MemberStatus{
    public RegularMember() {
    }


    @Override
    public int getLoanTime() {
        return 14;
    }
}
