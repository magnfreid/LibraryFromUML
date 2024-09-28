package Medium.Creators;

public class Publisher extends Creator {


     public Publisher(String name) {
        super(name);

    }
    @Override
    public String toString() {
        return "Publisher: " + name;
    }
}
