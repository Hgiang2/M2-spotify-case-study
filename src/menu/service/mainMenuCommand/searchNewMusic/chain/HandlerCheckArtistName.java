package menu.service.mainMenuCommand.searchNewMusic.chain;

import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;
import services.AllSpotifyArtistList;

public class HandlerCheckArtistName implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckArtistName(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        searchResult.getArtistResult().addAll(AllSpotifyArtistList.getInstance().search(searchResult.getSearchItem()));
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
