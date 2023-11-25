package services;

import constant.Constants;
import entity.Artist;
import entity.Favorites;
import entity.Song;
import services.observer.Observer;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocalArtistSongManagement implements LocalSongListManagement, Sortable, Observer {
    private List<Song> localSongs = new ArrayList<>();
    private Artist artist;

    public LocalArtistSongManagement() {
    }

    public LocalArtistSongManagement(Artist artist) {
        this.artist = artist;
    }

    private void generateLocalSongs() {
//        try {
//            localSongs.clear();
//            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
//                if (song.getArtist().equals(name)) localSongs.add(song);
//            }
//        } catch (NullPointerException e) {
//            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
//                if (song.getArtist().equals(name)) localSongs.add(song);
//            }
//        }
        localSongs = new ArrayList<>();
        for (Song song : AllSongsListManagement.getInstance().getSongs()) {
            if (song.getArtist().getUsername().equals(artist.getUsername())) localSongs.add(song);
        }
    }

    @Override
    public List<Song> getSongs() {
        return localSongs;
    }

    public String getTitle() {
        return artist.getUsername();
    }

    @Override
    public void addToFavorites(Song song) {
        Favorites.getInstance().getSongsInPlaylist().add(song);
    }

    @Override
    public void addMultipleToFavorites(int[] choice) {
//        String[] choices = choice.split(" ");
        for (int number : choice) {
            Song thisSong = localSongs.get(number);
            Validator validate = new ValidateCheckSongExistInList(thisSong, Favorites.getInstance().getSongsInPlaylist());
            if (!validate.isCheck()) this.addToFavorites(thisSong);
        }
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
        localSongs.sort(Constants.SORT_SONG_BY_NAME);
    }

    @Override
    public void sortZA() {
        sortAZ();
        Collections.reverse(localSongs);
    }

    @Override
    public void sortByOldest() {
        localSongs.sort(Constants.SORT_SONG_BY_DATE);
    }

    @Override
    public void sortByNewest() {
        sortByOldest();
    }

    @Override
    public void update() {
        generateLocalSongs();
    }

}
