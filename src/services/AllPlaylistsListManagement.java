package services;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import entity.Favorites;
import entity.Playlist;
import services.observer.Observer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPlaylistsListManagement implements Searchable, Observer {
    private List<Playlist> allPlaylists = new ArrayList<>();
    private static AllPlaylistsListManagement instance;

    private AllPlaylistsListManagement() {
        Type playlistType = new TypeToken<List<Playlist>>() {
        }.getType();
        allPlaylists.add(Favorites.getInstance());
        Constants.fileHandler.saveToFile(Constants.ALL_PLAYLIST_FILE_PATH, allPlaylists);
        allPlaylists = (ArrayList<Playlist>) Constants.fileHandler.readFromFile(Constants.ALL_PLAYLIST_FILE_PATH, playlistType);
    }

    public static AllPlaylistsListManagement getInstance() {
        if (instance == null) {
            instance = new AllPlaylistsListManagement();
        }
        return instance;
    }

    public List<Playlist> getAllPlaylists() {
        return allPlaylists;
    }


    public List<Playlist> search(String name) {
        List<Playlist> playlistsResult = new ArrayList<>();
        for (Playlist playlist : allPlaylists) {
            if (playlist.getName().toLowerCase().contains(name.toLowerCase())) {
                playlistsResult.add(playlist);
            }
        }
        return playlistsResult;
    }

    public void sortAZ() {
        allPlaylists.sort(Constants.SORT_PLAYLIST_BY_NAME);
    }

    public void sortZA() {
        allPlaylists.sort(Constants.SORT_PLAYLIST_BY_NAME);
        Collections.reverse(allPlaylists);
    }

    public void sortByNewest() {
        allPlaylists.sort(Constants.SORT_PLAYLIST_BY_DATE);
        Collections.reverse(allPlaylists);
    }

    public void sortByOldest() {
        allPlaylists.sort(Constants.SORT_PLAYLIST_BY_DATE);
    }

    @Override
    public void update() {
        for (Playlist playlist : allPlaylists) {
            if (new SongInPlaylistManagement(playlist).getSongs().isEmpty()) allPlaylists.remove(playlist);
        }
        Constants.fileHandler.saveToFile(Constants.ALL_PLAYLIST_FILE_PATH, allPlaylists);
    }
}
