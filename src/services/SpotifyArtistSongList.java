package services;

import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SpotifyArtistSongList implements AllSongListManagement {
    private String name;
    private List<Song> spotifySongs = new ArrayList<>();

    public SpotifyArtistSongList(String name) {
        this.name = name;
        generateSpotifySongs();
    }

    private void generateSpotifySongs() {
        for (Song song : AllSpotifySongList.getInstance().getSongs()) {
            if (song.getArtist().equals(name)) spotifySongs.add(song);
        }
    }

    @Override
    public List<Song> getSongs() {
        return spotifySongs;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void streamInOrder() {

    }

    @Override
    public void streamRandomly() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void next() {

    }

    @Override
    public void addToFavorites(Song song) {

    }

    @Override
    public void addMultipleToFavorites(String choice) {

    }

    @Override
    public void addToPlaylists(Song song) {

    }

    @Override
    public void addMultipleToPlaylists(String choice) {

    }
}

