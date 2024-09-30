package Medium.Medium;


public abstract class PhysicalMedia extends Medium{
    protected int pages;

    protected PhysicalMedia(String title, int year, int pages) {
        super(title, year);
        this.pages = pages;
    }
}
