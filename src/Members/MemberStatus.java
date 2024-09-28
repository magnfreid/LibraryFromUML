package Members;

public enum MemberStatus {
    REGULAR("Regular member", 14),
    VIP("VIP member", 28);

    private final String description;
    private final int loanTime;

    MemberStatus(String description, int loanTime) {
        this.description = description;
        this.loanTime = loanTime;
    }

    public String getDescription() {
        return description;
    }

    public int getLoanTime() {
        return loanTime;
    }
}
