package Medium.Medium;

import Loan.Loan;
import Medium.Creators.Creator;
import Members.Member;
import Search.Searchable;

public abstract class Medium implements Searchable {
    protected String title;
    protected int year;
    protected Creator creator;


 Medium(String title, int year) {
        this.title = title;
        this.year = year;
    }


    public void loan(Member member) {
     member.getLoans().add(new Loan(this));
    }
    public String getTitle() {
        return title;
    }

    public Creator getCreator(){
     return creator;
    }

    @Override
    public boolean matchesSearch(String search) {
     return title.toLowerCase().contains(search.toLowerCase());
    }
}


