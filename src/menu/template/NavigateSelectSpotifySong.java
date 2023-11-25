package menu.template;

import constant.Constants;
import entity.Song;
import menu.features.addToFavorites.addSingle.CommandAddSingleSongToFavoritesProcess;
import menu.features.addToPlaylists.addSingle.CommandAddSingleSongToPlaylistProcess;
import menu.features.download.CommandDownloadSingleSong;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamSingleSong;

public class NavigateSelectSpotifySong implements Navigator{
    private Song song;
    private Navigator navigateBack;

    public NavigateSelectSpotifySong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    private void displaySelectSpotifySongMenu() {
        Menu menuSpotifySong = new MenuTemplate(song.getName(), song.toString());
        menuSpotifySong.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuSpotifySong.addMenuItem(new MenuItem("Stream", new CommandStreamSingleSong(song, this)));
        menuSpotifySong.addMenuItem(new MenuItem("Download", new CommandDownloadSingleSong(song, this)));
        menuSpotifySong.addMenuItem(new MenuItem("Add to Favorites", new CommandAddSingleSongToFavoritesProcess(song, this)));
        menuSpotifySong.addMenuItem(new MenuItem("Add to Playlists", new CommandAddSingleSongToPlaylistProcess(song, this)));
        menuSpotifySong.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSpotifySong.runMenu();
    }

    @Override
    public void navigate() {
        displaySelectSpotifySongMenu();
    }
}
