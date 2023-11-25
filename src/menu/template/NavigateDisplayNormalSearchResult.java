package menu.template;

import constant.Constants;
import entity.Artist;
import entity.Song;
import menu.features.exitCommand.CommandBack;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.selectSearchResult.CommandSelectNormalSpotifyArtist;
import menu.features.selectSearchResult.CommandSelectNormalSpotifySong;

public class NavigateDisplayNormalSearchResult implements Navigator{
    private SearchNewMusicResult searchResult;

    public NavigateDisplayNormalSearchResult(SearchNewMusicResult searchResult) {
        this.searchResult = searchResult;
    }

    private void displayNormalResult() {
        Menu menuSearchResult = new MenuResultListTemplate("All Spotify Results", "All Results: ", searchResult.getSearchResult().size());
        for (Artist artist : searchResult.getArtistResult()) menuSearchResult.addMenuItem(new MenuItem(artist.getStageName(), new CommandSelectNormalSpotifyArtist(artist, this)));
        for (Song song : searchResult.getSongResult()) menuSearchResult.addMenuItem(new MenuItem(song.toString(), new CommandSelectNormalSpotifySong(song, this)));
        menuSearchResult.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, new CommandBack(new NavigateMenuNormalMain())));
        menuSearchResult.runMenu();
    }

    @Override
    public void navigate() {
        displayNormalResult();
    }
}
