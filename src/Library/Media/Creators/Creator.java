package Library.Media.Creators;

import Library.Search.Searchable;

import java.util.ArrayList;

public abstract class Creator<T> implements Searchable<T> {
     protected String name;

    protected Creator(String name) {
        this.name = name;
    }

    public abstract ArrayList<T> result(String search);
}
