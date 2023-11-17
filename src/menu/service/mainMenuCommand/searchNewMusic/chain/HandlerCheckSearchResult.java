package menu.service.mainMenuCommand.searchNewMusic.chain;

import menu.menuCommand.NavigateNoItemFound;
import menu.menuCommand.Navigator;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;

public class HandlerCheckSearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSearchResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        return !searchResult.getSearchResult().isEmpty();
    }

    @Override
    public void handle(SearchNewMusicResult searchResult) {
        if (!doHandle(searchResult)) {
            Navigator navigatorNotFound = new NavigateNoItemFound();
            navigatorNotFound.navigate();
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
