package entity;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private List<Song> thisArtistSong;
    private String name;

    public Artist(String name) {
        this.name = name;
        this.thisArtistSong = new ArrayList<>();
    }

    public List<Song> getThisArtistSong() {
        return thisArtistSong;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
