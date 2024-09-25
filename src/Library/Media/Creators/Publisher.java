package Library.Media.Creators;

import Library.Media.Media.Types.Magazine;

import java.util.ArrayList;

public class Publisher extends Creator<Magazine>{
    ArrayList<Magazine> magazines;

    public Publisher(String name, ArrayList<Magazine> magazines) {
        super(name);
        this.magazines = magazines;
    }

    @Override
    public ArrayList<Magazine> result(String search) {
        return magazines;
    }
}
