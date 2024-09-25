package Library.Media.Media;

import Library.Search.Searchable;

public abstract class WrittenMedium<T> extends DigitalMedium<T> implements Searchable<T> {
    protected int pages;

    protected WrittenMedium(String title, int year, int pages) {
        super(title, year);
        this.pages = pages;
    }
}
