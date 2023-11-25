package menu.features.searchCommand.searchNewMusic.chain;

import menu.template.NavigateNoItemFound;
import menu.template.Navigator;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;

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
        System.out.println();
        System.out.println("Searching...");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!doHandle(searchResult)) {
            Navigator navigatorNotFound = new NavigateNoItemFound();
            navigatorNotFound.navigate();
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
