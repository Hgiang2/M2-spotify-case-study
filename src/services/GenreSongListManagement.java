package services;

import constant.Constants;
import entity.Song;
import services.observer.Observer;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenreSongListManagement implements LocalSongListManagement, Sortable, Observer {
    private String name;
    private List<Song> songs = new ArrayList<>();

    public GenreSongListManagement() {
    }

    public GenreSongListManagement(String name) {
        this.name = name;
        addGenreSongs();
    }

    private void addGenreSongs() {
//        try {
//            songs.clear();
//            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
//                for (String genre : song.getGenre()) {
//                    if (genre.equals(name)) songs.add(song);
//                }
//            }
//        } catch (NullPointerException e) {
//            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
//                for (String genre : song.getGenre()) {
//                    if (genre.equals(name)) songs.add(song);
//                }
//            }
//        }
        songs = new ArrayList<>();
        for (Song song : AllSongsListManagement.getInstance().getSongs()) {
            for (String genre : song.getGenre()) {
                if (genre.equals(name)) songs.add(song);
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
    public void addToFavorites(Song song) {

    }

    @Override
    public void addMultipleToFavorites(int[] choice) {

    }

    @Override
    public void addSongs(List<Song> song) {

    }

    @Override
    public void addToPlaylists(Song song) {

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
        for (Song song : AllSongsListManagement.getInstance().getSongs()) {
            Validator validator = new ValidateCheckSongExistInList(song, songs);
            if (!validator.isCheck()) {
                for (String genre : song.getGenre()) {
                    if (genre.equals(name)) songs.add(song);
                }
            }
        }
    }
}
