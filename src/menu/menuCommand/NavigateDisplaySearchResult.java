package menu.menuCommand;

import constant.Constants;
import entity.Song;
import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;
import menu.service.mainMenuCommand.selectSearchResult.CommandSelectSpotifyArtist;
import menu.service.mainMenuCommand.selectSearchResult.CommandSelectSpotifySong;

public class NavigateDisplaySearchResult implements Navigator{
    private SearchNewMusicResult searchResult;

    public NavigateDisplaySearchResult(SearchNewMusicResult searchResult) {
        this.searchResult = searchResult;
    }

    private void DisplaySearchResult() {
        Menu menuSearchResult = new MenuResultListTemplate("All Spotify Results", "All Results: ", searchResult.getSearchResult().size());
        for (String artist : searchResult.getArtistResult()) menuSearchResult.addMenuItem(new MenuItem(artist, new CommandSelectSpotifyArtist(artist, this)));
        for (Song song : searchResult.getSongResult()) menuSearchResult.addMenuItem(new MenuItem(song.toString(), new CommandSelectSpotifySong(song, this)));
        menuSearchResult.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSearchResult.runMenu();
    }
    @Override
    public void navigate() {
        DisplaySearchResult();
    }
}
