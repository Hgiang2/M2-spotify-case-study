package menu.template;

import constant.Constants;
import entity.Artist;
import entity.Playlist;
import entity.Song;
import menu.features.exitCommand.CommandBack;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.selectSearchResult.CommandSelectArtist;
import menu.features.selectSearchResult.CommandSelectLocalSong;
import menu.features.selectSearchResult.CommandSelectPlaylist;

public class NavigateDisplaySearchResultLocal implements Navigator{
    private SearchNewMusicResult searchResult;

    public NavigateDisplaySearchResultLocal(SearchNewMusicResult searchResult) {
        this.searchResult = searchResult;
    }

    private void displaySearchResult() {
        Menu menuSearchResult = new MenuResultListTemplate("All Spotify Results", "All Results: ", searchResult.getSearchResult().size());
        for (Playlist playlist : searchResult.getPlaylistResult()) menuSearchResult.addMenuItem(new MenuItem(playlist.getName(), new CommandSelectPlaylist(playlist, this)));
        for (Artist artist : searchResult.getArtistResult()) menuSearchResult.addMenuItem(new MenuItem(artist.getStageName(), new CommandSelectArtist(artist, this)));
        for (Song song : searchResult.getSongResult()) menuSearchResult.addMenuItem(new MenuItem(song.toString(), new CommandSelectLocalSong(song, this)));
        menuSearchResult.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menuSearchResult.runMenu();
    }
    @Override
    public void navigate() {
        displaySearchResult();
    }
}
