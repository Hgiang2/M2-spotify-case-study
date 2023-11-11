package services;

import constant.Constants;
import entity.Playlist;
import entity.Song;

import java.util.Collections;
import java.util.List;

public class PlaylistManagement implements MusicManagement {
    private List<Playlist> playlistList;
    private static PlaylistManagement instance;

    private PlaylistManagement() {
//        Playlist favorites = new Favorites();
//        this.playlistList = new ArrayList<>();
//        playlistList.add(favorites);
    }

    public static PlaylistManagement getInstance() {
        if (instance == null) {
            instance = new PlaylistManagement();
        }
        return instance;
    }

    public List<Playlist> getPlaylistList() {
        return playlistList;
    }

    @Override
    public void stream() {

    }

    @Override
    public void getStatus() {

    }

    public void displayAll() {
        System.out.println("Your Playlists");
        System.out.println("______________");
        System.out.println();
        Constants.DISPLAY_LIST.displayList(playlistList);
    }

    @Override
    public void addSong(Song song) {
        System.out.println();
    }

    @Override
    public void removeMultiple(String numbers) {
        String[] playlistNumbersRemove = numbers.split(" ");
        for (String number : playlistNumbersRemove) {
            playlistList.remove(playlistList.get(Integer.parseInt(number)));
        }
    }


    public Playlist search(String name) {
        for (Playlist playlist : playlistList) {
            if (name.equals(playlist.getName())) {
                return playlist;
            }
        }
        return null;
    }

    @Override
    public void sortAZ() {
        playlistList.sort(Constants.SORT_PLAYLIST_BY_NAME);
    }

    @Override
    public void sortZA() {
        playlistList.sort(Constants.SORT_PLAYLIST_BY_NAME);
        Collections.reverse(playlistList);
    }

    @Override
    public void sortByNewest() {
        playlistList.sort(Constants.SORT_PLAYLIST_BY_DATE);
        Collections.reverse(playlistList);
    }

    @Override
    public void sortByOldest() {
        playlistList.sort(Constants.SORT_PLAYLIST_BY_DATE);
    }
}
