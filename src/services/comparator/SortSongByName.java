package services.comparator;

import entity.Song;

import java.util.Comparator;

public class SortSongByName implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        return CharSequence.compare(o1.getName(), o2.getName());
    }
}
