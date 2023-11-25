package services;

import entity.Artist;
import entity.Song;
import services.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class AllArtistsListManagement implements Searchable, Observer {
    private List<Artist> localArtists;
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
        localArtists = new ArrayList<>();
        List<Song> allSongs = AllSongsListManagement.getInstance().getSongs();
        for (int i = 0; i < allSongs.size(); i++) {
            boolean isSameArtist = false;
            for (int j = 0; j < localArtists.size(); j++) {
                if (allSongs.get(i).getArtist().equals(localArtists.get(j))) {
                    isSameArtist = true;
                    break;
                }
            }
            if (isSameArtist) continue;
            localArtists.add(allSongs.get(i).getArtist());
        }
        for (int i = 0; i < localArtists.size(); i++) {
            if (new LocalArtistSongManagement(localArtists.get(i)).getSongs().isEmpty()) localArtists.remove(localArtists.get(i));
        }
    }

    public List<Artist> getList() {
        return localArtists;
    }


    @Override
    public List<Artist> search(String name) {
        List<Artist> artistResult = new ArrayList<>();
        for (Artist artist : localArtists) {
            if (artist.getStageName().toLowerCase().contains(name.toLowerCase())) {
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
