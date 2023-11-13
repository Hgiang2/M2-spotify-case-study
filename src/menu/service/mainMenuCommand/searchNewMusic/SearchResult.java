package menu.service.mainMenuCommand.searchNewMusic;

import entity.Artist;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private String searchItem;
    private List<Music> songResult;
    private List<Music> artistResult;
    List<String> searchResult;
//    private static SearchResult instance;
//    public static SearchResult getInstance() {
//        if (instance == null) {
//            instance = new SearchResult();
//        }
//        return instance;
//    }

    public SearchResult(String searchItem) {
        this.searchItem = searchItem;
        this.songResult = new ArrayList<>();
        this.artistResult = new ArrayList<>();
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

    public List<String> getSearchResult() {
        return searchResult;
    }
}
