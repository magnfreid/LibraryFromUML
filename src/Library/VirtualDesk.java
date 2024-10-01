package Library;

import Medium.Creators.Author;
import Medium.Creators.Creator;
import Medium.Creators.Director;
import Medium.Creators.Publisher;
import Medium.Medium.Medium;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Members.Member;
import Members.MemberStatus;
import Search.Searcher;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualDesk {
    private final Searcher searcher;
    private final Scanner scanner;
    private final Library library;
    private final String staffPassword;

    public VirtualDesk(Library library) {
        this.library = library;
        this.searcher = new Searcher(library);
        this.scanner = new Scanner(System.in);
        this.staffPassword = "1234";
    }

    public void openLibrary() {
        while (true) {
            System.out.println("\nWelcome to the library!");
            System.out.println("1. Member");
            System.out.println("2. Staff");
            System.out.println("3. Exit");
            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    memberMenu();
                    break;
                }
                case "2": {
                    staffMenu();
                    break;
                }
                case "3": {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid input, try again...");
                }
            }
        }
    }

    private void staffMenu() {
        boolean running = true;
        while (running) {
            System.out.println("***** STAFF *****");
            System.out.println("Enter password: ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("back")) {
                if (input.equals(staffPassword)) {
                    System.out.println("Password correct!");
                    System.out.println("\n1. Search members");
                    System.out.println("2. Add member");
                    System.out.println("3. Add media");
                    System.out.println("4. List all members");
                    System.out.println("5. Exit");
                    System.out.println("Enter: ");
                    input = scanner.nextLine();
                    if (!input.equalsIgnoreCase("back")) {
                        switch (input) {
                            case "1": {
                                System.out.println("Search member:");
                                String search = scanner.nextLine();
                                if (!search.equalsIgnoreCase("back")) {
                                    searchMemberMenu(search);
                                }
                                break;
                            }
                            case "2": {
                                System.out.println("*** Add new member ***");
                                System.out.println("Enter name:");
                                String name = scanner.nextLine();
                                if (!name.equalsIgnoreCase("back")) {
                                    addMemberMenu(name);
                                }
                                break;
                            }
                            case "3": {
                                System.out.println("*** Add new media to the library ***");
                                System.out.println("Choose media:");
                                System.out.println("1. Book");
                                System.out.println("2. Magazine");
                                System.out.println("3. DVD");
                                String mediaChoice = scanner.nextLine();
                                if (!mediaChoice.equalsIgnoreCase("back")) {
                                    addMediumMenu(mediaChoice);
                                }
                                break;
                            }
                            case "4": {
                                System.out.println("All members:");
                                library.printMembers(library.getMembers());
                            }
                            case "5": {
                                running = false;
                                break;
                            }
                        }
                    }

                } else {
                    System.out.println("Incorrect password.");
                }
            }
        }

    }


    private void memberMenu() {
        System.out.println("***** MEMBER *****");
        System.out.println("Enter member ID:");
        String input = scanner.nextLine();
        Member currentMember = null;
        for (Member member : library.getMembers()) {
            if (member.getId().equalsIgnoreCase(input)) {
                currentMember = member;
                break;
            }
        }
        if (currentMember != null) {
            System.out.println("1. Search media");
            System.out.println("2. Search authors, publisher or director");
            System.out.println("Enter:");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("back")) {
                switch (input) {
                    case "1": {
                        System.out.println("Search media: ");
                        String search = scanner.nextLine();
                        if (!search.equalsIgnoreCase("back")) {
                            searchMediaMenu(search);
                            //TODO lägg till att kunna välja media att låna
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Search creator:");
                        String search = scanner.nextLine();
                        if (!search.equalsIgnoreCase("back")) {
                            searchCreatorMenu(search);
                            //TODO lägg till att kunna välja skapare och se alla media att låna
                        }
                        break;
                    }
                    default: {
                        System.out.println("Invalid input, try again!");
                    }
                }
            }
        } else {
            System.out.println("Member with ID: " + input + " does not exist.");
        }
    }

    private void addMediumMenu(String mediaChoice) {
        switch (mediaChoice) {
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
                System.out.println(book + "\n*** Added to the library! ***");
                library.addBook(book);
                System.out.println("***     ***");
                break;
            }
            case "2": {
                System.out.println("*** Add magazine ***");
                System.out.println("Title:");
                String title = scanner.nextLine();
                System.out.println("Publisher:");
                String publisherName = scanner.nextLine();
                System.out.println("Year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Pages: ");
                int pages = scanner.nextInt();
                scanner.nextLine();
                Magazine magazine = new Magazine(title, new Publisher(publisherName), year, pages);
                System.out.println(magazine + "\n*** Added to the library! ***");
                library.addMagazine(magazine);
                System.out.println("***     ***");
                break;
            }
            case "3": {
                System.out.println("*** Add DVD ***");
                System.out.println("Title:");
                String title = scanner.nextLine();
                System.out.println("Director:");
                String directorName = scanner.nextLine();
                System.out.println("Year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Length (minutes): ");
                int lengthMinutes = scanner.nextInt();
                scanner.nextLine();
                DVD dvd = new DVD(title, new Director(directorName), year, lengthMinutes);
                System.out.println(dvd + "\n*** Added to the library! ***");
                library.addDVD(dvd);
                System.out.println("***     ***");
                break;
            }
            default: {
                System.out.println("Invalid input, try again!");
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
                System.out.println("Invalid input.");
            }
        }
        library.addMember(name, memberStatus);
        System.out.println(name + " was added as a member with status of " + memberStatus);
    }

    //TODO säkra felaktig input
    private void searchMemberMenu(String search) {
        ArrayList<Member> searchResult = searcher.searchMember(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            library.printMembers(searchResult);
            System.out.println("Choose member: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            Member chosenMember = searchResult.get(choice - 1);
            System.out.println(
                    chosenMember.getLoans().isEmpty()
                            ? chosenMember.getName() + " has no loans."
                            : "Loans:\n" + chosenMember.getLoans());
        }
    }


    private void searchMediaMenu(String search) {
        ArrayList<Medium> searchResult = searcher.searchMedium(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            library.printMediums(searchResult);
        }
    }

    //TODO Creator listan är tom och måste läggas till i JSON-filen, eller implementeras på annat sätt
    private void searchCreatorMenu(String search) {
        ArrayList<Creator> searchResult = searcher.searchCreator(search);
        System.out.println(searchResult.isEmpty() ? "No result was found for " + search : "Search result:");
        if (!searchResult.isEmpty()) {
            library.printCreators(searchResult);
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
