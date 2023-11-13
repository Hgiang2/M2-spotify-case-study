package entity;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllSongsList implements Observer {
    private List<Song> allSongs;
    private static AllSongsList instance;

    private AllSongsList() {
        Type songType = new TypeToken<List<Song>>() {}.getType();
//        allSongs = new ArrayList<>();
        allSongs = (ArrayList<Song>) Constants.fileHandler.readFromFile(Constants.ALL_SONG_FILE_PATH, songType);
    }

    public static AllSongsList getInstance() {
        if (instance == null) {
            instance = new AllSongsList();
        }
        return instance;
    }

    public List<Song> getAllSongs() {
        return allSongs;
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
        Song lastSong = (Song) allSongs.getLast();
        System.out.println(lastSong.getName() + " by " + lastSong.getArtist() + " added successfully!");}
}
