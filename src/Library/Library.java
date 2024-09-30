package Library;

import Medium.Creators.Creator;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Members.Member;
import Medium.Medium.Medium;
import Populator.LibraryData;
import Populator.JsonUtil;

import java.util.ArrayList;
import java.util.Objects;

import Members.MemberStatus;
import Populator.Populator;


public class Library {
    private ArrayList<Medium> mediums = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Creator> creators = new ArrayList<>();
    private final VirtualDesk virtualDesk;

    public Library() {
    LibraryData libraryData = new LibraryData();
    this.mediums = JsonUtil.readLibraryData().getMediums();
    this.members = JsonUtil.readLibraryData().getMembers();
      /*  Populator populator = new Populator();
        populator.loadMembers(this);
        populator.loadMediums(this);
        JsonUtil.saveLibraryData(mediums, members);*/
        this.virtualDesk = new VirtualDesk(this);
    }

    /**
     * The heart and command station of the library!
     * @return
     */
    public VirtualDesk virtualDesk() {
        return virtualDesk;
    }

    /**
     * Checks if creator (name) already exists before adding new medium.
     * @param newMedium
     */
    public void addMedium(Medium newMedium){
       Creator creator = null;
        for (Medium medium : mediums) {
            if (Objects.equals(medium.getCreator().getName(), newMedium.getCreator().getName())) {
                creator = medium.getCreator();
                }
        }
        if (creator == null) {
            creator = newMedium.getCreator(); {
            }
            creators.add(creator);
        }
        mediums.add(newMedium);
    }

    public void addBook(Book book) {
       addMedium(book);
    }

    public void addMagazine(Magazine magazine) {
        addMedium(magazine);
    }

    public void addDVD(DVD dvd) {
       addMedium(dvd);
    }

    /**
     * Checks if member already exists and only adds a new member if it doesn't.
     * @param name
     * @param memberStatus
     */
    public void addMember(String name, MemberStatus memberStatus) {
        boolean memberExists = false;
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                memberExists = true;
                System.out.println("Member already exists...");
                break;
            }
        }
        if (!memberExists) {
            Member newMember = new Member(name, memberStatus);
            members.add(newMember);
        }


    }



    public void printMediums() {
        for (Medium medium : mediums) {
            System.out.println("*****");
            System.out.println(medium.toString());
        }
    }

    public void printMembers() {
        for (Member member : members) {
            System.out.println("*****");
            System.out.println(member.toString());
        }
    }

    public ArrayList<Medium> getMediums() {
        return mediums;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Creator> getCreators() {
        return creators;
    }
}
