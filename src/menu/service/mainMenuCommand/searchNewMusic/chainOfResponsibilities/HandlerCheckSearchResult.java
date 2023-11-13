package menu.service.mainMenuCommand.searchNewMusic.chainOfResponsibilities;

import menu.menuCommand.NavigateNoItemFound;
import menu.menuCommand.Navigator;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchResult;

public class HandlerCheckSearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSearchResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchResult searchResult) {
        if (searchResult.getSongResult().isEmpty() && searchResult.getArtistResult().isEmpty()) return false;
        return true;
    }

    @Override
    public void handle(SearchResult searchResult) {
        if (!doHandle(searchResult)) {
            Navigator navigatorNotFound = new NavigateNoItemFound();
            navigatorNotFound.navigate();
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
