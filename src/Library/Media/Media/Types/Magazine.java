package Library.Media.Media.Types;

import Library.Media.Media.WrittenMedium;

import java.util.ArrayList;

public class Magazine extends WrittenMedium<Magazine> {
    protected Magazine(String title, int year, int pages) {
        super(title, year, pages);
    }

    @Override
    public ArrayList<Magazine> result(String search) {
        return null;
    }
}

