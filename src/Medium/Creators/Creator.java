package Medium.Creators;

import Search.Searchable;

public abstract class Creator implements Searchable {
     protected String name;

     Creator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean matchesSearch(String search) {
         return name.toLowerCase().contains(search.toLowerCase());
    }
}
