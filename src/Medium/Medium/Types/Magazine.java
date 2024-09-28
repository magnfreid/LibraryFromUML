package Medium.Medium.Types;

import Medium.Creators.Publisher;
import Medium.Medium.WrittenMedium;

public class Magazine extends WrittenMedium {

    public Magazine(String title, int year, int pages, Publisher publisher) {
        super(title, year, pages);
        this.creator = publisher;
    }

    @Override
    public String toString() {
        return "MAGAZINE" +
                "\nTitle: " + title +
                "\n" + creator +
                "\nYear: " + year +
                "\nPages: " + pages;

    }
}

