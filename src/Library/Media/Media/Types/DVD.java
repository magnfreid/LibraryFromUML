package Library.Media.Media.Types;

import Library.Media.Media.DigitalMedium;

import java.util.ArrayList;

public class DVD extends DigitalMedium<DVD> {

    protected DVD(String title, int year) {
        super(title, year);
    }

    @Override
    public ArrayList<DVD> result(String search) {
        ArrayList<DVD> result = new ArrayList<>();
        return result;
    }
}
