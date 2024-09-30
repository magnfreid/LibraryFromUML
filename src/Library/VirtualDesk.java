package Library;

import Medium.Creators.Author;
import Medium.Medium.Types.Book;
import Members.Member;
import Members.MemberStatus;
import Search.Searchable;
import Search.Searcher;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualDesk {
    private final Searcher searcher;
    private final Scanner scanner;
    private final Library library;

    public VirtualDesk(Library library) {
        this.library = library;
        this.searcher = new Searcher(library);
        this.scanner = new Scanner(System.in);
    }

    public void openLibrary() {
        while (true) {
            System.out.println("Welcome to the library!");
            System.out.println("1. Search media");
            System.out.println("2. Search members");
            System.out.println("3. Add member");
            System.out.println("4. Add media");
            System.out.println("5. List all members");
            System.out.println("6. Exit");
            System.out.println("Enter:");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println("Search media: ");
                    String search = scanner.nextLine();
                    if (!search.equalsIgnoreCase("back")) {
                        searchMediaMenu(search);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Search member:");
                    String search = scanner.nextLine();
                    if (!search.equalsIgnoreCase("back")) {
                        searchMemberMenu(search);
                    }
                    break;
                }
                case "3": {
                    System.out.println("*** Add new member ***");
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    if (!name.equalsIgnoreCase("back")) {
                        addMemberMenu(name);
                    }
                    break;
                }
                case "4": {
                    System.out.println("*** Add new media to the library ***");
                    System.out.println("Choose media:");
                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. DVD");
                    String mediaChoice = scanner.nextLine();
                    if (!mediaChoice.equalsIgnoreCase("back")) {
                        switch (mediaChoice.toLowerCase()) {
                            case "1": {
                                System.out.println("*** Add book ***");
                                System.out.println("Title:");
                                String title = scanner.nextLine();
                                System.out.println("Author:");
                                String authorName = scanner.nextLine();
                                System.out.println("Year: ");
                                int year = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Pages: ");
                                int pages = scanner.nextInt();
                                scanner.nextLine();
                                Book book = new Book(title, new Author(authorName), year, pages);
                                System.out.println(book +"\n*** Added to the library! ***");
                                library.addBook(book);
                                System.out.println("***     ***");
                                break;
                            }
                            case "2": {
                                break;                        }
                            case "3": {
                                break;
                            }
                            default: {
                                System.out.println("Invalid input, try again!");
                            }
                        }
                    }
                    break;
                }
                case "5": {
                    System.out.println("All members:");
                }
                case "6": {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid input, try again...");
                }

            }
        }
    }

    private void addMemberMenu(String name) {
        MemberStatus memberStatus = null;
        while (true) {
            System.out.println("Choose member status: ");
            printMemberStatuses();
            String memberStatusInput = scanner.nextLine();
            for (int i = 0; i < MemberStatus.values().length; i++) {
                try {
                    if (Integer.parseInt(memberStatusInput) == i + 1) {
                        memberStatus = MemberStatus.values()[i];
                        break;
                    }
                } catch (NumberFormatException e) {
                    break;
                }
            }
            if (memberStatus != null) {
                break;
            } else {
                System.out.println("Invalid input. Choose a member status.");
            }
        }
        library.addMember(name, memberStatus);
        System.out.println(name + " was added as a member with status of " + memberStatus);
    }

    private void searchMemberMenu(String search) {
        int searchIndex = 0;
        ArrayList<Member> searchResult = searcher.searchMember(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            for (Member member : searchResult) {
                System.out.println();
                System.out.println(searchIndex + 1 + ":");
                System.out.println(member);
                searchIndex++;
            }
        }
    }

    private void searchMediaMenu(String search) {
        int searchIndex = 0;
        ArrayList<Searchable> searchResult = searcher.searchLibrary(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            for (Searchable searchable : searchResult) {
                System.out.println();
                System.out.println(searchIndex + 1 + ":");
                System.out.println(searchable);
                searchIndex++;
            }
        }
    }

    public void printMemberStatuses() {
        int index = 0;
        for (MemberStatus status : MemberStatus.values()) {
            System.out.println(index + 1 + ": " + status.toString());
            index++;
        }
    }
}
