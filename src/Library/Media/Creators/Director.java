package Library.Media.Creators;

import Library.Media.Media.Types.DVD;

import java.util.ArrayList;

public class Director extends Creator<DVD> {
ArrayList<DVD> dvds;
    protected Director(String name, ArrayList<DVD> dvds) {
        super(name);
        this.dvds = dvds;
    }

    @Override
    public ArrayList<DVD> result(String search) {
        return dvds;
    }
}
