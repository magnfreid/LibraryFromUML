package Medium.Medium.Types;

import Medium.Creators.Publisher;
import Medium.Medium.PhysicalMedia;

public class Magazine extends PhysicalMedia {
final private String type;
    public Magazine(String title,Publisher publisher, int year, int pages) {
        super(title, year, pages);
        this.creator = publisher;
        this.type = "magazine";
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

