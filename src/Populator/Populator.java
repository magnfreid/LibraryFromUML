package Populator;

import Library.Library;
import Medium.Creators.Author;
import Medium.Creators.Director;
import Medium.Creators.Publisher;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Members.MemberStatus;

public class Populator {

    public void loadMediums(Library library) {
        library.addBook(new Book("Three Little Birds",new Author("Bob Marley"), 1979, 421));
        library.addMagazine(new Magazine("Gamereactor", 2015, 79, new Publisher("Gamreactor AB")));
        library.addDVD(new DVD("Forrest Gump", 1997, 122, new Director("Steven Spielberg")));
    }

    public void loadMembers(Library library) {
        library.addMember("Trevor", MemberStatus.REGULAR);
        library.addMember("Michelle", MemberStatus.VIP);
    }
}
