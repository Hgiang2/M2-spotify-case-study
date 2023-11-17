package services;

import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllGenreListManagement implements MusicListManagement, Observer {
    private List<String> allGenresList;
    private static AllGenreListManagement instance;
    private AllGenreListManagement() {
        allGenresList = new ArrayList<>();
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
        for (Song song : AllSongsListManagement.getInstance().getSongs()) {
            for (String songGenre : song.getGenre()) {
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
        for (String genre : allGenresList) {
            if (new GenreSongListManagement(genre).getSongs().isEmpty()) allGenresList.remove(genre);
        }
    }

    @Override
    public void update() {
        generateGenreList();
    }
}
