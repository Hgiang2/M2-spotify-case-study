package menu.features.searchCommand.searchLocalLibrary.chain;

import menu.template.NavigateDisplaySearchResultLocal;
import menu.template.Navigator;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;

public class HandlerDisplaySearchResultLocal implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerDisplaySearchResultLocal(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        Navigator navigator = new NavigateDisplaySearchResultLocal(searchResult);
        navigator.navigate();
        return true;    }

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
