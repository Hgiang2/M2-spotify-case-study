package services;

import constant.Constants;
import entity.Playlist;
import entity.Song;
import services.observer.Observer;
import services.observer.Subject;

import java.util.Collections;
import java.util.List;

public class SongInPlaylistManagement extends Subject implements PlaylistSongManagement, Observer {
    private Playlist playlist;
    private List<Song> songsInPlaylist;

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
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void streamInOrder() {

    }

    @Override
    public void streamRandomly() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void next() {

    }
    @Override
    public void addNewSong() {

    }
    @Override
    public void addLocalSong() {
        Observer observerPlaylist = new SongInPlaylistManagement(playlist);
        addObserver(observerPlaylist);

        notifyObserver();
        removeAll();
    }


    @Override
    public void addToFavorites(Song song) {

    }

    @Override
    public void addMultipleToFavorites(String choice) {

    }

    @Override
    public void addToPlaylists(Song song) {

    }

    @Override
    public void addMultipleToPlaylists(String choice) {

    }

//    @Override
//    public void addNewSong(Song song) {
//        Observer observerPlaylist = new SongInPlaylistManagement(playlist);
//        addObserver(observerPlaylist);
//        boolean isSameSong = false;
//        for (Song songInPlaylist : songsInPlaylist) {
//            if (song == songInPlaylist) {
//                isSameSong = true;
//                System.out.println("This song has already been added to this playlist.");
//                break;
//            }
//        }
//        if (!isSameSong) {
//            songsInPlaylist.add(song);
//            AllSongsListManagement.getInstance().getAllSongs().add(song);
//        }
//        notifyObserver();
//        removeAll();
//    }



    @Override
    public void removeMultiple(String choices) {
        notifyObserver();
        removeAll();

        notifyObserver();
        removeAll();
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
        for (Song playlistSong : songsInPlaylist) {
            boolean isSameSong = false;
            for (Song song : AllSongsListManagement.getInstance().getSongs()) {
                if (playlistSong == song) {
                    isSameSong = true;
                    break;
                }
            }
            if (!isSameSong) songsInPlaylist.remove(playlistSong);
        }
        playlist.getSongsInPlaylist().clear();
        playlist.getSongsInPlaylist().addAll(songsInPlaylist);
    }
}
