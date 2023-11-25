package menu.template;

import constant.Constants;
import entity.Artist;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.SpotifyArtistSongList;

public class NavigateSelectNormalSpotifyArtist implements Navigator {
    private Artist artist;
    private Navigator navigateBack;

    public NavigateSelectNormalSpotifyArtist(Artist artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    private void displayNormalArtistSelect() {
        AllSongListManagement thisArtistSongs = new SpotifyArtistSongList(artist.getStageName());
        Menu menuArtist = new MenuResultListTemplate(artist.getStageName(), artist.getStageName(), thisArtistSongs.getSongs().size());
        for (int i = 0; i < thisArtistSongs.getSongs().size(); i++) menuArtist.addMenuItem(new MenuItem(thisArtistSongs.getSongs().get(i).toString(), new CommandStreamSong(i, thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuArtist.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(thisArtistSongs, this)));
        menuArtist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, new CommandBack(new NavigateMenuNormalMain())));
        menuArtist.runMenu();
    }

    @Override
    public void navigate() {
        displayNormalArtistSelect();
    }
}
