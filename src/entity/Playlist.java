package entity;

import constant.Constants;
import services.AllPlaylistsListManagement;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songsInPlaylist;
//    private List<Song> songsNotInPlaylist;
    private String name;
    private long time;
    private String date;
    private boolean isStream;

    public Playlist() {
    }

    public Playlist(String name) {
        this.name = name;
//        this.songsInPlaylist = new ArrayList<>();
        this.time = System.currentTimeMillis();
        this.date= Constants.FORMAT_DATE.formatDate();
        this.isStream = false;
        this.songsInPlaylist = new ArrayList<>();
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

    public String getDate() {
        return date;
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

    public boolean isStream() {
        return isStream;
    }

    public void setStream(boolean stream) {
        isStream = stream;
    }

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
