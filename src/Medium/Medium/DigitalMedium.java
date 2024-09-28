package Medium.Medium;


public abstract class DigitalMedium extends Medium {
protected int lengthMinutes;

     protected DigitalMedium(String name, int year, int lengthMinutes) {
        super(name, year);
        this.lengthMinutes = lengthMinutes;
    }
}
