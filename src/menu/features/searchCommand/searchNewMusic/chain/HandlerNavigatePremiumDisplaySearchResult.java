package menu.features.searchCommand.searchNewMusic.chain;

import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.template.NavigateDisplaySearchResult;
import menu.template.Navigator;

public class HandlerNavigatePremiumDisplaySearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerNavigatePremiumDisplaySearchResult(HandlerSearchItem next) {
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
