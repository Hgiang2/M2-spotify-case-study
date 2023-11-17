package entity;

import services.AllPlaylistsListManagement;

import java.util.List;

public class CurrentPlaylist {
    private List<Playlist> playlistList;
    private Playlist currentPlaylist;
    private CurrentPlaylist() {
        playlistList = AllPlaylistsListManagement.getInstance().getAllPlaylists();
    }
    private static CurrentPlaylist instance;
    public static CurrentPlaylist getInstance() {
        if(instance == null) {
            instance = new CurrentPlaylist();
        }
        return instance;
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist() {
        for(Playlist playlist : playlistList) {
            if(playlist.isStream()) {
                currentPlaylist = playlist;
                return;
            }
        }
    }
}
