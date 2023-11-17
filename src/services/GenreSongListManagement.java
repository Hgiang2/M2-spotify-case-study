package services;

import constant.Constants;
import entity.Song;
import services.observer.Observer;

import java.util.Collections;
import java.util.List;

public class GenreSongListManagement implements LocalSongListManagement, Observer {
    private String name;
    private List<Song> songs;

    public GenreSongListManagement(String name) {
        this.name = name;
        addGenreSongs();
    }

    private void addGenreSongs() {
        try {
            songs.clear();
            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
                for (String genre : song.getGenre()) {
                    if (genre.equals(name)) songs.add(song);
                }
            }
        } catch (NullPointerException e) {
            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
                for (String genre : song.getGenre()) {
                    if (genre.equals(name)) songs.add(song);
                }
            }
        }
    }

    @Override
    public List<Song> getSongs() {
        return songs;
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

    @Override
    public void removeMultiple(String choice) {

    }

    @Override
    public void sortAZ() {
        songs.sort(Constants.SORT_SONG_BY_NAME);
    }

    @Override
    public void sortZA() {
        sortAZ();
        Collections.reverse(songs);
    }

    @Override
    public void sortByOldest() {
        songs.sort(Constants.SORT_SONG_BY_DATE);
    }

    @Override
    public void sortByNewest() {
        sortByOldest();
        Collections.reverse(songs);
    }

    @Override
    public void update() {
        addGenreSongs();
    }
}
