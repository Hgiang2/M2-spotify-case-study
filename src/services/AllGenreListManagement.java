package services;

import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllGenreListManagement implements MusicListManagement, Observer {
    private List<String> allGenresList = new ArrayList<>();
    private static AllGenreListManagement instance;
    private AllGenreListManagement() {
        generateGenreList();
    }
    public static AllGenreListManagement getInstance() {
        if (instance == null) {
            instance = new AllGenreListManagement();
        }
        return instance;
    }
    @Override
    public List<String> getList() {
        return allGenresList;
    }

    private void generateGenreList() {
        allGenresList = new ArrayList<>();
        List<Song> allSongs = AllSongsListManagement.getInstance().getSongs();
        for (int i = 0; i < allSongs.size(); i++) {
            for (String songGenre : allSongs.get(i).getGenre()) {
                boolean isSameGenre = false;
                for (String genre : allGenresList) {
                    if (songGenre.equals(genre)) {
                        isSameGenre = true;
                        break;
                    }
                }
                if (!isSameGenre) allGenresList.add(songGenre);
            }
        }
        for (int i = 0; i < allGenresList.size(); i++) {
            if (new GenreSongListManagement(allGenresList.get(i)).getSongs().isEmpty()) allGenresList.remove(allGenresList.get(i));
        }
    }

    @Override
    public void update() {
        generateGenreList();
    }
}
