package Library;

import Medium.Creators.Author;
import Medium.Creators.Creator;
import Medium.Creators.Director;
import Medium.Creators.Publisher;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Members.Member;
import Medium.Medium.Medium;

import java.util.ArrayList;

import Members.MemberStatus;
import Populator.Populator;


public class Library {
    private final ArrayList<Medium> mediums = new ArrayList<>();
    private final ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Creator> creators = new ArrayList<>();
    private final VirtualDesk virtualDesk;

    public Library() {
        Populator populator = new Populator();
        populator.loadMediums(this);
        populator.loadMembers(this);
        this.virtualDesk = new VirtualDesk(this);
    }

    /**
     * The heart and command station of the library!
     * @return
     */
    public VirtualDesk virtualDesk() {
        return virtualDesk;
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

    /**
     * Prevents adding the same author more than once.
     * @param title
     * @param year
     * @param pages
     * @param authorName
     */
    public void addBook(String title, int year, int pages, String authorName) {
        Author author = null;
        for (Creator creator : creators) {
            if (creator instanceof Author) {
                if (creator.getName().equalsIgnoreCase(authorName)) {
                    author = (Author) creator;
                    break;
                }
            }
        }
        if (author == null) {
            author = new Author(authorName);
            creators.add(author);
        }
        Book book = new Book(title, year, pages, author);
        mediums.add(book);
    }

    /**
     * Prevents adding the same publisher more than once.
     * @param title
     * @param year
     * @param pages
     * @param publisherName
     */

    public void addMagazine(String title, int year, int pages, String publisherName) {
        Publisher publisher = null;
        for (Creator creator : creators) {
            if (creator instanceof Publisher) {
                if (creator.getName().equalsIgnoreCase(publisherName)) {
                    publisher = (Publisher) creator;
                    break;
                }
            }
        }
        if (publisher == null) {
            publisher = new Publisher(publisherName);
            creators.add(publisher);
        }
        Magazine magazine = new Magazine(title, year, pages, publisher);
        mediums.add(magazine);
    }


    /**
     * Prevents adding the same director more than once.
     * @param title
     * @param year
     * @param lengthMinutes
     * @param directorName
     */
    public void addDVD(String title, int year, int lengthMinutes, String directorName) {
        Director director = null;
        for (Creator creator : creators) {
            if (creator instanceof Director) {
                if (creator.getName().equalsIgnoreCase(directorName)) {
                    director = (Director) creator;
                    break;
                }
            }
        }
        if (director == null) {
            director = new Director(directorName);
            creators.add(director);
        }
        DVD magazine = new DVD(title, year, lengthMinutes, director);
        mediums.add(magazine);
    }

    /**
     * Checks if member already exists and adds a new member if it doesn't exist already.
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
