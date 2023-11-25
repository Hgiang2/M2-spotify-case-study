package services;

import entity.Favorites;
import entity.Song;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class SpotifyArtistSongList implements AllSongListManagement {
    private String artist;
    private List<Song> spotifySongs = new ArrayList<>();

    public SpotifyArtistSongList(String artist) {
        this.artist = artist;
        generateSpotifySongs();
    }

    private void generateSpotifySongs() {
        for (Song song : AllSpotifySongList.getInstance().getSongs()) {
            if (song.getArtist().getUsername().equals(artist)) spotifySongs.add(song);
        }
    }

    @Override
    public List<Song> getSongs() {
        return spotifySongs;
    }

    @Override
    public String getTitle() {
        return artist;
    }


    @Override
    public void addSongs(List<Song> song) {

    }

    @Override
    public void addToFavorites(Song song) {
        Favorites.getInstance().getSongsInPlaylist().add(song);
    }

    @Override
    public void addMultipleToFavorites(int[] choice) {
//        String[] choices = choice.split(" ");
        for (int number : choice) {
            Song thisSong = spotifySongs.get(number);
            Validator validate = new ValidateCheckSongExistInList(thisSong, Favorites.getInstance().getSongsInPlaylist());
            if (!validate.isCheck()) this.addToFavorites(thisSong);
        }
    }

    @Override
    public void addToPlaylists(Song song) {

    }
}

