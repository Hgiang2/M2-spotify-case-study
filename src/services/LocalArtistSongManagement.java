package services;

import constant.Constants;
import entity.Favorites;
import entity.Song;
import services.observer.Observer;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.util.Collections;
import java.util.List;

public class LocalArtistSongManagement implements LocalSongListManagement, Observer {
    private List<Song> localSongs;
    private String name;

    public LocalArtistSongManagement() {
    }

    public LocalArtistSongManagement(String name) {
        this.name = name;
        generateLocalSongs();
    }

    private void generateLocalSongs() {
        try {
            localSongs.clear();
            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
                if (song.getArtist().equals(name)) localSongs.add(song);
            }
        } catch (NullPointerException e) {
            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
                if (song.getArtist().equals(name)) localSongs.add(song);
            }
        }
    }

    @Override
    public List<Song> getSongs() {
        return localSongs;
    }

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
        Favorites.getInstance().getSongsInPlaylist().add(song);
    }

    @Override
    public void addMultipleToFavorites(String choice) {
        String[] choices = choice.split(" ");
        for (String number : choices) {
            Song thisSong = localSongs.get(Integer.parseInt(number));
            Validator validate = new ValidateCheckSongExistInList(thisSong, Favorites.getInstance().getSongsInPlaylist());
            if (!validate.isCheck()) this.addToFavorites(thisSong);
        }
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
