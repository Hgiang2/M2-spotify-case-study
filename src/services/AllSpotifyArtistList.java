package services;

import entity.Artist;
import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllSpotifyArtistList implements Searchable, Observer {
    private List<Artist> allSpotifyArtists;
    private static AllSpotifyArtistList instance;

    private AllSpotifyArtistList() {
        allSpotifyArtists = new ArrayList<>();
        generateArtistList();
    }

    private void generateArtistList() {
        for (Song song : AllSpotifySongList.getInstance().getSongs()) {
            boolean isSameArtist = false;

            for (Artist artist : allSpotifyArtists) {
                if (song.getArtist().getStageName().equals(artist.getStageName())) {
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

    public List<Artist> getList() {
        return allSpotifyArtists;
    }

    @Override
    public List<Artist> search(String name) {
        List<Artist> artistResult = new ArrayList<>();
        for (Artist artist : allSpotifyArtists) {
            if (artist.getStageName().toLowerCase().contains(name.toLowerCase())) {
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
