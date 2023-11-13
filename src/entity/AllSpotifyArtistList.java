package entity;

import java.util.ArrayList;
import java.util.List;

public class AllSpotifyArtistList {
    private List<Artist> allSpotifyArtists = new ArrayList<>();
    private static AllSpotifyArtistList instance;

    public static AllSpotifyArtistList getInstance() {
        if (instance == null) {
            instance = new AllSpotifyArtistList();
        }
        return instance;
    }

    private AllSpotifyArtistList() {
        for (Song song : AllSpotifySongList.getInstance().getSpotifySongs()) {
            boolean isSameArtist = false;
            for (Artist artist : allSpotifyArtists) {
                if (song.getArtist() == artist) {
                    isSameArtist = true;
                    break;
                }
            }
            if (isSameArtist) continue;
            allSpotifyArtists.add(song.getArtist());
        }
    }
}
