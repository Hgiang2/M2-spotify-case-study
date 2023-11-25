package menu.features.searchCommand;

import entity.Artist;
import entity.Playlist;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchNewMusicResult {
    private String searchItem;
    private List<Artist> artistResult = new ArrayList<>();
    private List<Song> songResult = new ArrayList<>();
    private List<Playlist> playlistResult = new ArrayList<>();
    private List<String> searchResult = new ArrayList<>();

    public SearchNewMusicResult(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public List<Song> getSongResult() {
        return songResult;
    }

    public List<Artist> getArtistResult() {
        return artistResult;
    }

    public List<Playlist> getPlaylistResult() {
        return playlistResult;
    }

    public List<String> getSearchResult() {
        return searchResult;
    }
}
