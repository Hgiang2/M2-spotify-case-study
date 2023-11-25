package menu.features.searchCommand.searchNewMusic.chain;

import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
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
