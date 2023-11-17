package services;

import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllSpotifyArtistList implements MusicListManagement, Searchable, Observer {
    private List<String> allSpotifyArtists;
    private static AllSpotifyArtistList instance;

    private AllSpotifyArtistList() {
        allSpotifyArtists = new ArrayList<>();
        generateArtistList();
    }

    private void generateArtistList() {
        for (Song song : AllSpotifySongList.getInstance().getSongs()) {
            boolean isSameArtist = false;
            for (String artist : allSpotifyArtists) {
                if (song.getArtist().equals(artist)) {
                    isSameArtist = true;
                    break;
                }
            }
            if (isSameArtist) continue;
            allSpotifyArtists.add(song.getArtist());
        }
    }

    public static AllSpotifyArtistList getInstance() {
        if (instance == null) {
            instance = new AllSpotifyArtistList();
        }
        return instance;
    }

    @Override
    public List<String> getList() {
        return allSpotifyArtists;
    }

    @Override
    public List<String> search(String name) {
        List<String> artistResult = new ArrayList<>();
        for (String artist : allSpotifyArtists) {
            if (artist.toLowerCase().contains(name.toLowerCase())) {
                artistResult.add(artist);
            }
        }
        return artistResult;
    }

    @Override
    public void update() {
        generateArtistList();
    }
}
