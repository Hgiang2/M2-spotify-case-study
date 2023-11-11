package services.comparator;

import entity.Song;

import java.util.Comparator;

public class SortSongByDate implements Comparator<Song> {
    @Override
    public int compare(Song song1, Song song2) {
        return Integer.compare((int) song1.getTime(), (int) song2.getTime());
    }
}
