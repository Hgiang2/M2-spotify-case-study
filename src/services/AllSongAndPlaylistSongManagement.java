package services;

import entity.Song;

import java.util.List;

public interface AllSongAndPlaylistSongManagement extends LocalSongListManagement{
    void addSongs(List<Song> selectedSong);
}
