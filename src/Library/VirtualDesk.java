package Library;

import Members.Member;
import Search.Searchable;
import Search.Searcher;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualDesk {
    private final Library library;
    private final Searcher searcher;
    private final Scanner scanner;

    public VirtualDesk(Library library) {
        this.library = library;
        this.searcher = new Searcher(library);
        this.scanner = new Scanner(System.in);
    }


    public void run() {
        System.out.println("Welcome to the library!");
        System.out.println("1. Search media");
        System.out.println("2. Search members");
        System.out.println("Enter:");
        String input = scanner.nextLine();
        switch (input)
        {
            case "1": {
                System.out.println("Search media: ");
                String search = scanner.nextLine();
                if (!search.equalsIgnoreCase("back")) {
                    searchMedia(search);
                }
                break;
            }
            case "2": {

                System.out.println("Search member:");
                String search = scanner.nextLine();
                if (!search.equalsIgnoreCase("back")) {
                    searchMember(search);
                }

                break;
            }
            default: {
                System.out.println("Invalid input, try again...");
            }

        }
    }

    private void searchMember(String search) {
        int searchIndex = 0;
        ArrayList<Member> searchResult = searcher.searchMember(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            for (Member member : searchResult) {
                System.out.println();
                System.out.println(searchIndex +1 +":");
                System.out.println(member);
                searchIndex++;
            }
        }
    }

    private void searchMedia(String search) {
        int searchIndex= 0;
        ArrayList<Searchable> searchResult = searcher.searchLibrary(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            for (Searchable searchable : searchResult) {
                System.out.println();
                System.out.println(searchIndex+1 + ":");
                System.out.println(searchable);
                searchIndex++;
            }
        }
    }
}
