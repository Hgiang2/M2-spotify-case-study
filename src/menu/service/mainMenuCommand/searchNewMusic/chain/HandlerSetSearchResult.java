package menu.service.mainMenuCommand.searchNewMusic.chain;

import entity.Song;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;

public class HandlerSetSearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerSetSearchResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        searchResult.getSearchResult().addAll(searchResult.getArtistResult());
        for (Song song : searchResult.getSongResult()) {
            searchResult.getSearchResult().add(song.toString());
        }
        return true;
    }

    @Override
    public void handle(SearchNewMusicResult searchResult) {
        if (!doHandle(searchResult)) {
            return;
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}

