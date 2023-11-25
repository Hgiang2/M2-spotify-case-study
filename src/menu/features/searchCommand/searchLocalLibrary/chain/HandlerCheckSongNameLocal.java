package menu.features.searchCommand.searchLocalLibrary.chain;

import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import services.AllSongsListManagement;

public class HandlerCheckSongNameLocal implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSongNameLocal(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        searchResult.getSongResult().addAll(AllSongsListManagement.getInstance().search(searchResult.getSearchItem()));
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
