package Populator;

import Library.Library;
import Members.MemberStatus;

public class Populator {

    public void loadMediums(Library library) {
        library.addBook("Three Little Birds", 1979, 421, "Bob Marley");
        library.addMagazine("Gamereactor", 2015, 79, "Gamreactor AB");
        library.addDVD("Forrest Gump", 1997, 122, "Steven Spielberg");

    }


    public void loadMembers(Library library) {
        library.addMember("Trevor", MemberStatus.REGULAR);
        library.addMember("Michelle", MemberStatus.VIP);
    }
}
