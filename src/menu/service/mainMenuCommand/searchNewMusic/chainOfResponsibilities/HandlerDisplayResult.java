package menu.service.mainMenuCommand.searchNewMusic.chainOfResponsibilities;

import entity.Artist;
import entity.Song;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchResult;

import java.util.List;

public class HandlerDisplayResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerDisplayResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchResult searchResult) {
        List<Song> songResult = searchResult.getSongResult();
        List<Artist> artistResult = searchResult.getArtistResult();
        for (int i = 0; i < songResult.size() + artistResult.size(); i++) {
            if (i >= artistResult.size()) {
                for (int j = 0; j < songResult.size(); j++) {
                    System.out.println(i + 1 + ". " + songResult.get(j).toString());
                    i++;
                }
            }
            System.out.println(i + 1 + ". " + artistResult.get(i).toString());
            searchResult.getSearchResult().add(artistResult.get(i).toString());
        }
        return true;
    }

    @Override
    public void handle(SearchResult searchResult) {
        if (!doHandle(searchResult)) {
            return;
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
