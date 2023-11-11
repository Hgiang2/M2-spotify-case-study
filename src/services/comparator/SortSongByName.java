package services.comparator;

import entity.Song;

import java.util.Comparator;

public class SortSongByName implements Comparator<Song> {
    @Override
    public int compare(Song song1, Song song2) {
        return Integer.compare(song1.getName().charAt(0), song2.getName().charAt(0));
    }
}
