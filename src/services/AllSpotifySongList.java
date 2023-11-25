package services;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import entity.Song;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllSpotifySongList implements AllSongListManagement, Searchable, Observer {
    private List<Song> spotifySongs;
    private static AllSpotifySongList instance;

    private AllSpotifySongList() {
        try {
            Type songType = new TypeToken<List<Song>>() {
            }.getType();
            spotifySongs = (ArrayList<Song>) Constants.fileHandler.readFromFile(Constants.SPOTIFY_SONG_FILE_PATH, songType);
        } catch (NullPointerException e) {
            spotifySongs = new ArrayList<>();
        }
    }

    public static AllSpotifySongList getInstance() {
        if (instance == null) {
            instance = new AllSpotifySongList();
        }
        return instance;
    }

    @Override
    public List<Song> getSongs() {
        return spotifySongs;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public void addSongs(List<Song> song) {

    }

    @Override
    public void addToFavorites(Song song) {

    }

    @Override
    public void addMultipleToFavorites(int[] choice) {

    }

    @Override
    public void addToPlaylists(Song song) {

    }

    @Override
    public List<Song> search(String name) {
        List<Song> songResult = new ArrayList<>();
        for (Song song : spotifySongs) {
            if (song.getName().toLowerCase().contains(name.toLowerCase())) {
                songResult.add(song);
            }
        }
        return songResult;
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, spotifySongs);
//        Song lastSong = spotifySongs.getLast();
//        System.out.println(lastSong.getName() + " by " + lastSong.getArtist() + " added to Spotify database successfully!");
    }
}
