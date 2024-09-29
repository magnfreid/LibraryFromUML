package Medium.Medium.Types;

import Medium.Creators.Author;
import Medium.Medium.WrittenMedium;

public class Book extends WrittenMedium {

    public Book(String title, Author author, int year, int pages) {
        super(title, year, pages);
        this.creator = author;
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
