package services.comparator;

import java.util.Comparator;

public class SortStringByName implements Comparator<String> {
    @Override
    public int compare(String string1, String string2) {
        return CharSequence.compare(string1, string2);
    }
}
