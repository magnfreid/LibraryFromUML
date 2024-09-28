package Medium.Medium;


public abstract class WrittenMedium extends Medium{
    protected int pages;

    protected WrittenMedium(String title, int year, int pages) {
        super(title, year);
        this.pages = pages;
    }
}
