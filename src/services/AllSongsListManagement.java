package services;

import com.google.gson.reflect.TypeToken;
import constant.Constants;
import entity.Playlist;
import entity.Song;
import services.observer.Observer;
import services.observer.Subject;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSongsListManagement extends Subject implements AllSongAndPlaylistSongManagement, Searchable, Sortable, Observer {
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
    public void addToFavorites(Song song) {

    }

    @Override
    public void addMultipleToFavorites(int[] choice) {

    }

    @Override
    public void addToPlaylists(Song song) {

    }

    @Override
    public void addSongs(List<Song> selectedSong) {

    }

    @Override
    public String getTitle() {
        return "All Songs";
    }

    @Override
    public void removeMultiple(String numbers) {
        Observer observerAllGenres = AllGenreListManagement.getInstance();
        Observer observerAllArtists = AllArtistsListManagement.getInstance();
        addObserver(this);
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
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylist);

        for (Playlist playlist : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
            Observer observePlaylistSong = new SongInPlaylistManagement(playlist);
            addObserver(observePlaylistSong);
            for (int i = 0; i < playlist.getSongsInPlaylist().size(); i++) {
                Validator validator = new ValidateCheckSongExistInList(playlist.getSongsInPlaylist().get(i), allSongs);
                if (!validator.isCheck()) playlist.getSongsInPlaylist().remove(playlist.getSongsInPlaylist().get(i));
            }
        }

        notifyObserver();
        removeAll();

        Constants.fileHandler.saveToFile(Constants.ALL_SONG_FILE_PATH, allSongs);
    }
}
