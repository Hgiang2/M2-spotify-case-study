package entity;

import java.util.ArrayList;
import java.util.List;

public class AllArtistsList {
    private List<Artist> spotifyArtists = new ArrayList<>();
    private static AllArtistsList instance;
    public static AllArtistsList getInstance() {
        if (instance == null) {
            instance = new AllArtistsList();
        }
        return instance;
    }
    private AllArtistsList() {
        for (Song song : AllSongsList.getInstance().getAllSongs()) {
            boolean isSameArtist = false;
            for (Artist artist : spotifyArtists) {
                if (song.getArtist() == artist) {
                    isSameArtist = true;
                    break;
                }
            }
            if (isSameArtist) continue;
            spotifyArtists.add(song.getArtist());
        }
    }

    public List<Artist> getSpotifyArtists() {
        return spotifyArtists;
    }
}
