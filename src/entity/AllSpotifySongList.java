package entity;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllSpotifySongList implements Observer {
    private List<Song> spotifySongs;
    private static AllSpotifySongList instance;

    private AllSpotifySongList() {
        Type songType = new TypeToken<List<Song>>() {
        }.getType();
//        spotifySongs = new ArrayList<>();
        spotifySongs = (ArrayList<Song>) Constants.fileHandler.readFromFile(Constants.SPOTIFY_SONG_FILE_PATH, songType);
    }

    public static AllSpotifySongList getInstance() {
        if (instance == null) {
            instance = new AllSpotifySongList();
        }
        return instance;
    }

    public List<Song> getSpotifySongs() {
        return spotifySongs;
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, spotifySongs);
        Song lastSong = spotifySongs.getLast();
        System.out.println(lastSong.getName() + " by " + lastSong.getArtist() + " added to Spotify database successfully!");
    }
}
