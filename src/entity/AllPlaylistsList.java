package entity;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllPlaylistsList implements Observer {
    private List<Playlist> allPlaylists;
    private static AllPlaylistsList instance;

    private AllPlaylistsList() {
        Type playlistType = new TypeToken<List<Playlist>>() {}.getType();
        allPlaylists = (ArrayList<Playlist>) Constants.fileHandler.readFromFile(Constants.ALL_PLAYLIST_FILE_PATH, playlistType);
        allPlaylists.add(Favorites.getInstance());
    }

    public static AllPlaylistsList getInstance() {
        if (instance == null) {
            instance = new AllPlaylistsList();
        }
        return instance;
    }

    public List<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    @Override
    public void update() {
        Constants.fileHandler.saveToFile(Constants.ALL_PLAYLIST_FILE_PATH, allPlaylists);
        Playlist lastPlaylist = allPlaylists.getLast();
        System.out.println(lastPlaylist.getName() + " created successfully!");
    }
}
