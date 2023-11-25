package menu.template;

import constant.Constants;
import entity.Artist;
import entity.Song;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.selectSearchResult.CommandSelectSpotifyArtist;
import menu.features.selectSearchResult.CommandSelectSpotifySong;

public class NavigateDisplaySearchResult implements Navigator{
    private SearchNewMusicResult searchResult;

    public NavigateDisplaySearchResult(SearchNewMusicResult searchResult) {
        this.searchResult = searchResult;
    }

    private void DisplaySearchResult() {
        Menu menuSearchResult = new MenuResultListTemplate("All Spotify Results", "All Results: ", searchResult.getSearchResult().size());
        for (Artist artist : searchResult.getArtistResult()) menuSearchResult.addMenuItem(new MenuItem(artist.getUsername(), new CommandSelectSpotifyArtist(artist, this)));
        for (Song song : searchResult.getSongResult()) menuSearchResult.addMenuItem(new MenuItem(song.toString(), new CommandSelectSpotifySong(song, this)));
        menuSearchResult.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSearchResult.runMenu();
    }
    @Override
    public void navigate() {
        DisplaySearchResult();
    }
}
