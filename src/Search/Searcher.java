package Search;

import Library.Library;
import Medium.Creators.Creator;
import Medium.Medium.Medium;
import Members.Member;

import java.util.ArrayList;

public class Searcher {
    private final Library library;


    public Searcher(Library library) {
        this.library = library;
    }

    /**
     * Searches through all media and creators.
     *
     * @param search
     * @return
     */
    public ArrayList<Medium> searchMedium(String search) {
        ArrayList<Medium> searchResult = new ArrayList<>();
        for (Medium medium : library.getMediums()) {
            if (medium.matchesSearch(search)) {
                searchResult.add(medium);
            }
        }

        return searchResult;
    }

    /**
     * Searches through all registered members.
     *
     * @param search
     * @return
     */
    public ArrayList<Member> searchMember(String search) {
        ArrayList<Member> searchResult = new ArrayList<>();
        for (Member member : library.getMembers()) {
            if (member.matchesSearch(search)) {
                searchResult.add(member);
            }
        }
        return searchResult;
    }

    public ArrayList<Creator> searchCreator(String search) {
        ArrayList<Creator> searchResult = new ArrayList<>();
        for (Creator creator : library.getCreators()) {
            if (creator.matchesSearch(search)) {
                searchResult.add(creator);
            }
        }
        return searchResult;
    }
}



