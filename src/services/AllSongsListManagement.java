package services;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import entity.Playlist;
import entity.Song;
import services.observer.Observer;
import services.observer.Subject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSongsListManagement extends Subject implements AllSongAndPlaylistSongManagement, Searchable, Observer {
    private List<Song> allSongs;
    private static AllSongsListManagement instance;

    private AllSongsListManagement() {
        try {
            Type songType = new TypeToken<List<Song>>() {
            }.getType();
            allSongs = (ArrayList<Song>) Constants.fileHandler.readFromFile(Constants.ALL_SONG_FILE_PATH, songType);
        } catch (NullPointerException e) {
            allSongs = new ArrayList<>();
        }
    }

    public static AllSongsListManagement getInstance() {
        if (instance == null) {
            instance = new AllSongsListManagement();
        }
        return instance;
    }

    @Override
    public List<Song> getSongs() {
        return allSongs;
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

    @Override
    public void addNewSong() {

    }

    @Override
    public String getTitle() {
        return "All Songs";
    }
    //    @Override
//    public void addNewSong(Song song) {
//        for (String genre : AllGenreListManagement.getInstance().getAllGenresList()) {
//            Observer observerGenre = new GenreSongListManagement(genre);
//            addObserver(observerGenre);
//        }
//        for (String artist : AllArtistsListManagement.getInstance().getLocalArtists()) {
//            Observer observerArtist = new LocalArtistSongManagement(artist);
//            addObserver(observerArtist);
//        }
//        Observer observerAllGenres = AllGenreListManagement.getInstance();
//        Observer observerAllArtists = AllArtistsListManagement.getInstance();
//        addObserver(observerAllArtists);
//        addObserver(observerAllGenres);
//
//        boolean isSameSong = false;
//        for (Song song1 : allSongs) {
//            if (song == song1) {
//                isSameSong = true;
//                System.out.println("This song is already existed.");
//                break;
//            }
//        }
//        if (!isSameSong) {
//            allSongs.add(song);
//        }
//
//        notifyObserver();
//        removeAll();
//    }

    @Override
    public void removeMultiple(String numbers) {
        for (Playlist playlist : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
            Observer observerPlaylist = new SongInPlaylistManagement(playlist);
            addObserver(observerPlaylist);
        }
        for (String genre : AllGenreListManagement.getInstance().getList()) {
            Observer observerGenre = new GenreSongListManagement(genre);
            addObserver(observerGenre);
        }
        for (String artist : AllArtistsListManagement.getInstance().getList()) {
            Observer observerArtist = new LocalArtistSongManagement(artist);
            addObserver(observerArtist);
        }
        Observer observerAllPlaylist = AllPlaylistsListManagement.getInstance();
        Observer observerAllGenres = AllGenreListManagement.getInstance();
        Observer observerAllArtists = AllArtistsListManagement.getInstance();
        addObserver(observerAllPlaylist);
        addObserver(observerAllArtists);
        addObserver(observerAllGenres);

        String[] songNumbersRemove = numbers.split(" ");
        for (int i = 0; i < songNumbersRemove.length; i++) {
            int index = Integer.parseInt(songNumbersRemove[i]);
            allSongs.remove(index);
        }
        notifyObserver();
        removeAll();
    }

    @Override
    public List<Song> search(String name) {
        List<Song> songResult = new ArrayList<>();
        for (Song song : allSongs) {
            if (song.getName().toLowerCase().contains(name.toLowerCase())) {
                songResult.add(song);
            }
        }
        return songResult;
    }

    @Override
    public void sortAZ() {
        allSongs.sort(Constants.SORT_SONG_BY_NAME);
    }

    @Override
    public void sortZA() {
        allSongs.sort(Constants.SORT_SONG_BY_NAME);
        Collections.reverse(allSongs);
    }

    @Override
    public void sortByNewest() {
        allSongs.sort(Constants.SORT_SONG_BY_DATE);
        Collections.reverse(allSongs);
    }

    @Override
    public void sortByOldest() {
        allSongs.sort(Constants.SORT_SONG_BY_DATE);
    }

    @Override
    public void update() {
//        for (Song song : allSongs) {
//            boolean isSameSong = false;
//            for (Playlist playlist : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
//                for (Song songInPlaylist : new SongInPlaylistManagement(playlist).getSongsInPlaylist()) {
//                    if (song == songInPlaylist) {
//                        isSameSong = true;
//                        break;
//                    }
//                }
//            }
//            if (!isSameSong) allSongs.add
//        }
        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
    }
}
