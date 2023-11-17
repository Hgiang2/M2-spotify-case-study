package services.validator;

import entity.Song;

import java.util.List;

public class ValidateCheckSongExistInList implements Validator{
    private Song song;
    private List<Song> songList;

    public ValidateCheckSongExistInList(Song song, List<Song> songList) {
        this.song = song;
        this.songList = songList;
    }

    @Override
    public boolean isCheck() {
        for(Song songInList : songList) {
            if(song == songInList) {
                return true;
            }
        }
        return false;
    }
}
