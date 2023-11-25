package menu.features.searchCommand.searchLocalLibrary.chain;

import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import services.AllArtistsListManagement;

public class HandlerCheckArtistNameLocal implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckArtistNameLocal(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        searchResult.getArtistResult().addAll(AllArtistsListManagement.getInstance().search(searchResult.getSearchItem()));
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
