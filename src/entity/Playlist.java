package entity;

import constant.Constants;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songsInPlaylist = new ArrayList<>();
    private long time;
    public Playlist() {
        this.time = System.currentTimeMillis();
    }

    public Playlist(String name) {
        this.name = name;
        this.time = System.currentTimeMillis();
        AllPlaylistsListManagement.getInstance().getAllPlaylists().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public List<Song> getSongsInPlaylist() {
        return songsInPlaylist;
    }
//    public List<Song> getSongsNotInPlaylist() {
//        List<Song> allSongs = services.AllSongsList.getInstance().getAllSongs();
//        List<Song> songsNotInPlaylist = new ArrayList<>();
////        return allSongs.stream()
////                .filter(song -> allSongs.contains(songsInPlaylist))
////                .collect(Collectors.toList());
//        for (int i = 0; i < songsInPlaylist.size(); i++) {
//            if (allSongs.get(i) == songsInPlaylist.get(i)) songsNotInPlaylist.add(allSongs.get(i));
//        }
//        return songsNotInPlaylist;
//    }

    @Override
    public String toString() {
        return name;
    }
//
//    @Override
//    public void update() {
//        List<Song> songs = new SongInPlaylistManagement(this).getSongsInPlaylist();
//        songs.sort(Constants.SORT_SONG_BY_DATE);
//        songsInPlaylist = songs;
//    }
}
