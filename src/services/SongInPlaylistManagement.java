package services;

import constant.Constants;
import entity.Favorites;
import entity.Playlist;
import entity.Song;
import services.observer.Observer;
import services.observer.Subject;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.util.Collections;
import java.util.List;

public class SongInPlaylistManagement extends Subject implements AllSongListManagement, Sortable, Observer {
    private Playlist playlist;
    private List<Song> songsInPlaylist;

    public SongInPlaylistManagement() {
    }

    public SongInPlaylistManagement(Playlist playlist) {
        this.playlist = playlist;
        this.songsInPlaylist = playlist.getSongsInPlaylist();
    }

    @Override
    public List<Song> getSongs() {
        return songsInPlaylist;
    }

    @Override
    public String getTitle() {
        return playlist.getName();
    }

    @Override
    public void addSongs(List<Song> selectedSong) {
        Observer observeAllPlaylists = AllPlaylistsListManagement.getInstance();
        Observer observeAllSongs = AllSongsListManagement.getInstance();
        addObserver(this);
        addObserver(observeAllPlaylists);
        addObserver(observeAllSongs);
        for (int i = 0; i < selectedSong.size(); i++) {
            Validator validator = new ValidateCheckSongExistInList(selectedSong.get(i), songsInPlaylist);
            if (!validator.isCheck()) {
                songsInPlaylist.add(selectedSong.get(i));
                selectedSong.get(i).setTime(System.currentTimeMillis());
            }
        }
        notifyObserver();
        removeAll();
    }


    @Override
    public void addToFavorites(Song song) {
        Favorites.getInstance().getSongsInPlaylist().add(song);
    }

    @Override
    public void addMultipleToFavorites(int[] choice) {
        for (int number : choice) {
            Song thisSong = songsInPlaylist.get(number);
            Validator validate = new ValidateCheckSongExistInList(thisSong, Favorites.getInstance().getSongsInPlaylist());
            if (!validate.isCheck()) {
                this.addToFavorites(thisSong);
                thisSong.setTime(System.currentTimeMillis());
            }
        }
    }

    @Override
    public void addToPlaylists(Song song) {

    }


    @Override
    public void sortAZ() {
        songsInPlaylist.sort(Constants.SORT_SONG_BY_NAME);
    }

    @Override
    public void sortZA() {
        sortAZ();
        Collections.reverse(songsInPlaylist);
    }

    @Override
    public void sortByOldest() {
        songsInPlaylist.sort(Constants.SORT_SONG_BY_DATE);
    }

    @Override
    public void sortByNewest() {
        sortByOldest();
        Collections.reverse(songsInPlaylist);
    }

    @Override
    public void update() {
//        for (Song playlistSong : songsInPlaylist) {
//            Validator validator = new ValidateCheckSongExistInList(playlistSong, AllSongsListManagement.getInstance().getSongs());
//            if (!validator.isCheck()) songsInPlaylist.remove(playlistSong);
//        }
        for (Playlist playlist : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
            for (int i = 0; i < playlist.getSongsInPlaylist().size(); i++) {
                Validator validator = new ValidateCheckSongExistInList(playlist.getSongsInPlaylist().get(i), AllSongsListManagement.getInstance().getSongs());
                if (!validator.isCheck()) AllSongsListManagement.getInstance().getSongs().add(playlist.getSongsInPlaylist().get(i));
            }
        }
//        playlist.getSongsInPlaylist().clear();
//        playlist.getSongsInPlaylist().addAll(songsInPlaylist);
    }
}
