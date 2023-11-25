package menu.features.searchCommand.searchLocalLibrary.chain;

import menu.template.NavigateNoItemFoundLocal;
import menu.template.Navigator;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;

public class HandlerCheckSearchResultLocal implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSearchResultLocal(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        return !searchResult.getSearchResult().isEmpty();
    }

    @Override
    public void handle(SearchNewMusicResult searchResult) {
        if (!doHandle(searchResult)) {
            Navigator navigatorNotFound = new NavigateNoItemFoundLocal();
            navigatorNotFound.navigate();
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
