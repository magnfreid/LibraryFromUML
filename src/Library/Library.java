package Library;

import Medium.Creators.Creator;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Members.Member;
import Medium.Medium.Medium;
import Data.Helpers.JsonUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import Members.MemberStatus;


public class Library {
    private ArrayList<Medium> mediums = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    //TODO creators måste implementeras
    private final ArrayList<Creator> creators = new ArrayList<>();
    private final VirtualDesk virtualDesk;

    public Library() {
        this.mediums = JsonUtil.readLibraryData().getMediums();
        this.members = JsonUtil.readLibraryData().getMembers();
        this.virtualDesk = new VirtualDesk(this);
    }

    /**
     * The heart and command station of the library!
     *
     * @return
     */
    public VirtualDesk virtualDesk() {
        return virtualDesk;
    }

    /**
     * Checks if creator (name) already exists before adding new medium.
     *
     * @param newMedium
     */
    public void addMedium(Medium newMedium) {
        Creator creator = null;
        for (Medium medium : mediums) {
            if (Objects.equals(medium.getCreator().getName(), newMedium.getCreator().getName())) {
                creator = medium.getCreator();
                break;
            }
        }
        if (creator == null) {
            creator = newMedium.getCreator();
            creators.add(creator);
        }
        mediums.add(newMedium);
        JsonUtil.saveLibraryData(mediums, members);
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
     *
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
            Member newMember = new Member(name, memberStatus, generateID());
            members.add(newMember);
            JsonUtil.saveLibraryData(mediums, members);
        }
    }

    private String generateID() {
        Random random = new Random();
        String id;
        while (true) {
            boolean idIsUnique = true;
            int randomID = random.nextInt(5000);
            id = String.format("%04d", randomID);
            for (Member member : members) {
                if (member.getId().equals(id)) {
                    idIsUnique = false;
                    break;
                }
            }
            if (idIsUnique) {
                break;
            }
        }
        return id;
    }

    public void printMediums(ArrayList<Medium> mediums) {
        int index = 0;
        for (Medium medium : mediums) {
            System.out.println(index + 1 + ":");
            System.out.println(medium);
            index++;
        }
    }

    public void printMembers(ArrayList<Member> members) {
        int index = 0;
        for (Member member : members) {
            System.out.println(index + 1 + ":");
            System.out.println(member);
            index++;
        }
    }

    public void printCreators(ArrayList<Creator> creators) {
        int index = 0;
        for (Creator creator : creators) {
            System.out.println(index + 1 + ":");
            System.out.println(creator);
            index++;
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

