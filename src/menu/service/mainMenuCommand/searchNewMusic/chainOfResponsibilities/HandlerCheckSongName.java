package menu.service.mainMenuCommand.searchNewMusic.chainOfResponsibilities;

import entity.AllSpotifySongList;
import entity.Song;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchResult;

import java.util.List;


public class HandlerCheckSongName implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckSongName(HandlerSearchItem next) {
        this.next = next;
    }
    @Override
    public boolean doHandle(SearchResult searchResult) {
        List<Song> allSpotifySongs = AllSpotifySongList.getInstance().getSpotifySongs();
        for (Song song : allSpotifySongs) {
            if (song.getName().toLowerCase().contains(searchResult.getSearchItem().toLowerCase())) {
                searchResult.getSongResult().add(song);
            }
        }
        return true;
    }

    @Override
    public void handle(SearchResult searchResult) {
        if (!doHandle(searchResult)) {
            return;
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
