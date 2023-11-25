package menu.template;

import constant.Constants;
import menu.features.addToFavorites.addMultiple.CommandAddMultipleToFavorites;
import menu.features.addToPlaylists.selectSongs.CommandAddMultipleToPlaylists;
import menu.features.download.CommandDownloadMultipleSong;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.SpotifyArtistSongList;

public class NavigateSelectSpotifyArtist implements Navigator{
    private String artist;
    private Navigator navigateBack;

    public NavigateSelectSpotifyArtist(String artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    private void DisplayArtistMenu() {
        AllSongListManagement thisArtistSongs = new SpotifyArtistSongList(artist);
        Menu menuArtist = new MenuResultListTemplate(artist, artist, thisArtistSongs.getSongs().size());
        for (int i = 0; i < thisArtistSongs.getSongs().size(); i++) menuArtist.addMenuItem(new MenuItem(thisArtistSongs.getSongs().get(i).toString(), new CommandStreamSong(i, thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem("Download Multiple", new CommandDownloadMultipleSong(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_FAVORITES, new CommandAddMultipleToFavorites(thisArtistSongs, navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_PLAYLISTS, new CommandAddMultipleToPlaylists(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuArtist.runMenu();
    }

    @Override
    public void navigate() {
        DisplayArtistMenu();
    }
}
