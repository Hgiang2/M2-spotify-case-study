package services;

import entity.Song;

import java.util.List;

public interface AllSongListManagement {
    List<Song> getSongs();
    String getTitle();
    void play();
    void stop();
    void streamInOrder();
    void streamRandomly();
    void previous();
    void next();
    void addToFavorites(Song song);
    void addMultipleToFavorites(String choice);
    void addToPlaylists(Song song);
    void addMultipleToPlaylists(String choice);
}
