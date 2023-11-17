package menu.service.mainMenuCommand.searchNewMusic;

import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchNewMusicResult {
    private String searchItem;
    private List<String> artistResult = new ArrayList<>();
    private List<Song> songResult = new ArrayList<>();
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

    public List<String> getArtistResult() {
        return artistResult;
    }

    public List<String> getSearchResult() {
        return searchResult;
    }
    public void setSearchResult(List<String> searchResult) {
        this.searchResult = searchResult;
    }
}
