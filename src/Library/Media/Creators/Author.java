package Library.Media.Creators;

import Library.Media.Media.Types.Book;

import java.util.ArrayList;

public class Author extends Creator<Book> {
    ArrayList<Book> books;


    public Author(String name, ArrayList<Book> books) {
        super(name);
        this.books = books;
    }

    @Override
    public ArrayList<Book> result(String search) {
        return books;
    }
}
