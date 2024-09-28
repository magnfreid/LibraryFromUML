package Medium.Creators;

public class Director extends Creator {

     public Director(String name) {
        super(name);

    }

    @Override
    public String toString() {
        return "Director: " + name;
    }
}
