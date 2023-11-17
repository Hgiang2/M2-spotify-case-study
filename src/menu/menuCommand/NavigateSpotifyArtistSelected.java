package menu.menuCommand;

import constant.Constants;
import entity.Song;
import services.SpotifyArtistSongList;
import menu.service.addToFavoritesCommand.CommandAddMultipleToFavorites;
import menu.service.CommandAddMultipleToPlaylists;
import menu.service.exitCommand.CommandBack;
import menu.service.mainMenuCommand.selectSearchResult.CommandStreamSong;
import menu.service.streamCommand.CommandStreamListNext;
import menu.service.streamCommand.CommandStreamListOrderly;
import menu.service.streamCommand.CommandStreamListPrevious;
import menu.service.streamCommand.CommandStreamListRandomly;
import services.AllSongListManagement;

public class NavigateSpotifyArtistSelected implements Navigator{
    private String artist;
    private Navigator navigateBack;

    public NavigateSpotifyArtistSelected(String artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    private void DisplayArtistMenu() {
        AllSongListManagement thisArtistSongs = new SpotifyArtistSongList(artist);
        Menu menuArtist = new MenuResultListTemplate(artist, artist, thisArtistSongs.getSongs().size());
        for (Song song : thisArtistSongs.getSongs()) menuArtist.addMenuItem(new MenuItem(song.toString(), new CommandStreamSong(song)));
        menuArtist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.STREAM_IN_ORDER, new CommandStreamListOrderly(thisArtistSongs)));
        menuArtist.addMenuItem(new MenuItem(Constants.STREAM_RANDOMLY, new CommandStreamListRandomly(thisArtistSongs)));
        menuArtist.addMenuItem(new MenuItem(Constants.NEXT, new CommandStreamListPrevious(thisArtistSongs)));
        menuArtist.addMenuItem(new MenuItem(Constants.PREVIOUS, new CommandStreamListNext(thisArtistSongs)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_FAVORITES, new CommandAddMultipleToFavorites(thisArtistSongs, navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_PLAYLISTS, new CommandAddMultipleToPlaylists(thisArtistSongs, navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuArtist.runMenu();
    }

    @Override
    public void navigate() {
        DisplayArtistMenu();
    }
}
