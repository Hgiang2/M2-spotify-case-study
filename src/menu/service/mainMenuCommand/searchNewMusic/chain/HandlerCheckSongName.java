package menu.service.mainMenuCommand.searchNewMusic.chain;

import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;
import services.AllSpotifySongList;


public class HandlerCheckSongName implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSongName(HandlerSearchItem next) {
        this.next = next;
    }
    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        searchResult.getSongResult().addAll(AllSpotifySongList.getInstance().search(searchResult.getSearchItem()));
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
