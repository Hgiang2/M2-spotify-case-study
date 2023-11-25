package menu.template;

import constant.Constants;
import entity.Artist;
import menu.features.addToPlaylists.selectSongs.CommandAddMultipleToPlaylists;
import menu.features.addToFavorites.addMultiple.CommandAddMultipleToFavorites;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.LocalArtistSongManagement;

public class NavigateSelectLocalArtist implements Navigator{
    private Artist artist;
    private Navigator navigateBack;

    public NavigateSelectLocalArtist(Artist artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    private void DisplayArtistMenu() {
        AllSongListManagement thisArtistSongs = new LocalArtistSongManagement(artist);
        Menu menuArtist = new MenuResultListTemplate(artist.getUsername(), artist.getUsername(), thisArtistSongs.getSongs().size());
        for (int i = 0; i < thisArtistSongs.getSongs().size(); i++) menuArtist.addMenuItem(new MenuItem(thisArtistSongs.getSongs().get(i).toString(), new CommandStreamSong(i, thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_FAVORITES, new CommandAddMultipleToFavorites(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.ADD_MULTIPLE_TO_PLAYLISTS, new CommandAddMultipleToPlaylists(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuArtist.runMenu();
    }

    @Override
    public void navigate() {
        DisplayArtistMenu();
    }
}
