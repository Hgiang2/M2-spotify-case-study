package menu.service.mainMenuCommand.searchNewMusic.chainOfResponsibilities;

import entity.AllSpotifySongList;
import entity.Song;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.SearchResult;

import java.util.List;

public class HandlerCheckArtistName implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckArtistName(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchResult searchResult) {
        List<Song> allSpotifySongs = AllSpotifySongList.getInstance().getSpotifySongs();
        List<Song> allSpotifyArtists =
        for (Song song : allSpotifySongs) {

            String spotifyArtist = (song.getArtist().getName().toLowerCase());
            if (spotifyArtist.contains(searchResult.getSearchItem().toLowerCase())) {
                searchResult.getArtistResult().add(song.getArtist());
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
