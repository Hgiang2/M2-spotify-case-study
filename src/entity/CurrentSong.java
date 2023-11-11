package entity;

import java.util.List;

public class CurrentSong {
    private List<Song> songList;
    private Song currentSong;
    private CurrentSong() {
        songList = AllSongsList.getInstance().getAllSongs();
    }
    private static CurrentSong instance;
    public static CurrentSong getInstance() {
        if(instance == null) {
            instance = new CurrentSong();
        }
        return instance;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong() {
        for(Song song : songList) {
            if(song.isStream()) {
                currentSong = song;
                return;
            }
        }
    }
}
