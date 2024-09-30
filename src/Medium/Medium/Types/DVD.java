package Medium.Medium.Types;

import Medium.Creators.Director;
import Medium.Medium.DigitalMedium;


public class DVD extends DigitalMedium {
    final private String type;

    public DVD(String title, int year, int lengthMinutes, Director director) {
        super(title, year, lengthMinutes);
        this.type = "dvd";
        this.creator = director;

    }

    @Override
    public String toString() {
        return "DVD" +
                "\nTitle: " + title +
                "\n" + creator +
                "\nMinutes: " + lengthMinutes +
                "\nYear: " + year;
    }
}
