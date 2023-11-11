package services;

import constant.Constants;
import entity.AllSongsList;
import entity.Song;

import java.util.Collections;
import java.util.List;

public class SongManagement implements MusicManagement {
    private List<Song> songList;
    private static SongManagement instance;
    private SongManagement() {
        this.songList = AllSongsList.getInstance().getAllSongs();
    }

    public static SongManagement getInstance() {
        if (instance == null) {
            instance = new SongManagement();
        }
        return instance;
    }
    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public void stream() {

    }

    @Override
    public void getStatus() {

    }

    @Override
    public void addSong(Song song) {
        songList.add(song);
    }

    @Override
    public void removeMultiple(String numbers) {
        String[] songNumbersRemove = numbers.split(" ");
        for (int i = 0; i < songNumbersRemove.length; i++) {
            int index = Integer.parseInt(songNumbersRemove[i]);
            Song removedSong = songList.remove(index);
            for (int j = 0; j < Constants.PLAYLIST_LIST.size(); j++) {
                List<Song> playlist = Constants.PLAYLIST_LIST.get(j).getSongsInPlaylist();
                for (int k = 0; k < playlist.size(); k++) {
                    if (playlist.get(k) == removedSong) {
                        playlist.remove(removedSong);
                    }
                }
            }
        }
    }

    public void displayAll() {
        Constants.DISPLAY_LIST.displayList(songList);
    }

    public Song search(String name) {
        for (Song song : songList) {
            if (name.equals(song.getName()) || name.equals(song.getArtist())) {
                return song;
            }
        }
        return null;
    }

    public void sortAZ() {
        songList.sort(Constants.SORT_SONG_BY_NAME);
    }

    public void sortZA() {
        songList.sort(Constants.SORT_SONG_BY_NAME);
        Collections.reverse(songList);
    }

    public void sortByNewest() {
        songList.sort(Constants.SORT_SONG_BY_DATE);
        Collections.reverse(songList);
    }

    public void sortByOldest() {
        songList.sort(Constants.SORT_SONG_BY_DATE);
    }
}
