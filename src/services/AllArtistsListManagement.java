package services;

import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllArtistsListManagement implements MusicListManagement, Searchable, Observer {
    private List<String> localArtists;
    private static AllArtistsListManagement instance;

    private AllArtistsListManagement() {
        localArtists = new ArrayList<>();
        extractArtists();
    }

    public static AllArtistsListManagement getInstance() {
        if (instance == null) {
            instance = new AllArtistsListManagement();
        }
        return instance;
    }

    private void extractArtists() {
        for (Song song : AllSongsListManagement.getInstance().getSongs()) {
            boolean isSameArtist = false;
            for (String artist : localArtists) {
                if (song.getArtist().equals(artist)) {
                    isSameArtist = true;
                    break;
                }
            }
            if (isSameArtist) continue;
            localArtists.add(song.getArtist());
        }
        for (String artist : localArtists) {
            if (new LocalArtistSongManagement(artist).getSongs().isEmpty()) localArtists.remove(artist);
        }
    }

    @Override
    public List<String> getList() {
        return localArtists;
    }


    @Override
    public List<String> search(String name) {
        List<String> artistResult = new ArrayList<>();
        for (String artist : localArtists) {
            if (artist.toLowerCase().contains(name.toLowerCase())) {
                artistResult.add(artist);
            }
        }
        return artistResult;
    }

    @Override
    public void update() {
        extractArtists();
    }
}
