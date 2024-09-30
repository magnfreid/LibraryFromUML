package Medium.Medium.Types;

import Medium.Creators.Author;
import Medium.Medium.PhysicalMedia;

public class Book extends PhysicalMedia {
    final private String type;

    public Book(String title, Author author, int year, int pages) {
        super(title, year, pages);
        this.creator = author;
        this.type = "book";
    }


    @Override
    public String toString() {
        return "BOOK" +
                "\nTitle: " + title +
                "\n" + creator +
                "\nYear: " + year +
                "\nPages: " + pages;

    }
}
