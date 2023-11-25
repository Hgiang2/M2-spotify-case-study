package menu.features.searchCommand.searchNewMusic.chain;

import entity.Artist;
import entity.Playlist;
import entity.Song;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;

public class HandlerSetSearchResult implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerSetSearchResult(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        for (Playlist playlist : searchResult.getPlaylistResult()) {
            searchResult.getSearchResult().add(playlist.getName());
        }
        for (Artist artist : searchResult.getArtistResult()) {
            searchResult.getSearchResult().add(artist.toString());
        }
        for (Song song : searchResult.getSongResult()) {
            searchResult.getSearchResult().add(song.toString());
        }
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

