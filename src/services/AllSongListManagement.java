package services;

import entity.Song;

import java.util.List;

public interface AllSongListManagement {
    List<Song> getSongs();
    String getTitle();
    void addToFavorites(Song song);
    void addMultipleToFavorites(int[] choice);
    void addToPlaylists(Song song);
    void addSongs(List<Song> song);
}
