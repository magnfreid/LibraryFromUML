package Data.Helpers;

import Medium.Medium.Medium;
import Members.Member;

import java.util.ArrayList;

public class LibraryData {
    private ArrayList<Medium> mediums;
    private ArrayList<Member> members;

    public LibraryData() {
        this.mediums = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public ArrayList<Medium> getMediums() {
        return mediums;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMediums(ArrayList<Medium> mediums) {
        this.mediums = mediums;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "LibraryData{" +
                "mediums=" + mediums +
                ", members=" + members +
                '}';
    }
}
