package entity;

import com.google.gson.reflect.TypeToken;
import constant.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SpotifyDatabaseSongList {
    private List<Song> spotifySongs;
    private static SpotifyDatabaseSongList instance;

    private SpotifyDatabaseSongList() {
        Type songType = new TypeToken<List<Song>>() {
        }.getType();
//        spotifySongs = new ArrayList<>();
        spotifySongs = (ArrayList<Song>) Constants.fileHandler.readFromFile(Constants.SPOTIFY_SONG_FILE_PATH, songType);
    }

    public static SpotifyDatabaseSongList getInstance() {
        if (instance == null) {
            instance = new SpotifyDatabaseSongList();
        }
        return instance;
    }

    public List<Song> getSpotifySongs() {
        return spotifySongs;
    }

//    @Override
//    public void update() {
//        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
//        Song lastSong = allSongs.getLast();
//        System.out.println(lastSong.getName() + " by " + lastSong.getArtist() + " added successfully!");
//    }
}
