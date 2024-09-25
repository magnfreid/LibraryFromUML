package Library.Media.Media;

import Library.Search.Searchable;

public abstract class DigitalMedium<T> implements Searchable<T> {
    final protected String title;
    final protected int year;

    protected DigitalMedium(String title, int year) {
        this.title = title;
        this.year = year;
    }
}
