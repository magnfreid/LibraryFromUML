package Medium.Creators;


public class Author extends Creator {


    public Author(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Author: " + name;
    }
}