package menu.service.mainMenuCommand.searchNewMusic.chain;

import menu.menuCommand.NavigateDisplaySearchResult;
import menu.menuCommand.Navigator;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;

public class HandlerNavigateDisplaySearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerNavigateDisplaySearchResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        Navigator navigator = new NavigateDisplaySearchResult(searchResult);
        navigator.navigate();
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
