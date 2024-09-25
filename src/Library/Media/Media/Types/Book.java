package Library.Media.Media.Types;

import Library.Media.Creators.Author;
import Library.Media.Media.WrittenMedium;

import java.util.ArrayList;

public class Book extends WrittenMedium<Book> {
Author author;

    protected Book(String title, int year, int pages, Author author) {
        super(title, year, pages);
        this.author = author;
    }

    @Override
    public ArrayList<Book> result(String search) {
        return null;
    }
}
