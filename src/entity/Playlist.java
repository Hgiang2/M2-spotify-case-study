package entity;

import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songsInPlaylist;
//    private List<Song> songsNotInPlaylist;
    private String name;
    private long time;
    private String date;
    private boolean isStream;

    public Playlist(String name) {
        this.name = name;
        this.songsInPlaylist = new ArrayList<>();
        this.time = System.currentTimeMillis();
        this.date= Constants.FORMAT_DATE.formatDate();
        this.isStream = false;
        AllPlaylistsList.getInstance().getAllPlaylists().add(this);
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
    public List<Song> getSongsNotInPlaylist() {
        List<Song> allSongs = AllSongsList.getInstance().getAllSongs();
        List<Song> songsNotInPlaylist = new ArrayList<>();
//        return allSongs.stream()
//                .filter(song -> allSongs.contains(songsInPlaylist))
//                .collect(Collectors.toList());
        for (int i = 0; i < songsInPlaylist.size(); i++) {
            if (allSongs.get(i) == songsInPlaylist.get(i)) songsNotInPlaylist.add(allSongs.get(i));
        }
        return songsNotInPlaylist;
    }

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
//    public void addSong(Song song) {
//        songsInPlaylist.add(song);
//        Constants.ALL_SONGS.add(song);
//    }
//
//    public void addMultipleSongsFromExistedList(String songNumbers) {
//        String[] songNumbersAdd = songNumbers.split(" ");
//        for (String number : songNumbersAdd) {
//            songsInPlaylist.add(Constants.ALL_SONGS.get(Integer.parseInt(number)));
//        }
//    }
//
//    @Override
//    public void removeMultiple(String numbers) {
//        String[] songNumbersRemove = numbers.split(" ");
//        for (String number : songNumbersRemove) {
//            songsInPlaylist.remove(songsInPlaylist.get(Integer.parseInt(number)));
//        }
//    }
//
//    @Override
//    public void displayAll() {
//        System.out.println("Playlist: " + name);
//        Constants.DISPLAY_LIST.displayList(songsInPlaylist);
//    }
//
//    @Override
//    public void sortAZ() {
//        songsInPlaylist.sort(Constants.SORT_SONG_BY_NAME);
//    }
//
//    @Override
//    public void sortZA() {
//        songsInPlaylist.sort(Constants.SORT_SONG_BY_NAME);
//        Collections.reverse(songsInPlaylist);
//    }
//
//    @Override
//    public void sortByNewest() {
//        songsInPlaylist.sort(Constants.SORT_SONG_BY_DATE);
//        Collections.reverse(songsInPlaylist);
//    }
//
//    @Override
//    public void sortByOldest() {
//        songsInPlaylist.sort(Constants.SORT_SONG_BY_DATE);
//    }
}
