package menu.template;

import constant.Constants;
import entity.Song;
import menu.features.addToFavorites.addSingle.CommandAddSingleSongToFavoritesProcess;
import menu.features.addToPlaylists.addSingle.CommandAddSingleSongToPlaylistProcess;
import menu.features.deleteLocalSong.CommandDeleteLocalSong;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamSingleSong;

public class NavigateSelectLocalSong implements Navigator {
    private Song song;
    private Navigator navigateBack;

    public NavigateSelectLocalSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    private void displayLocalSongMenu() {
        Menu menuSong = new MenuTemplate(song.getName(), song.toString());
        menuSong.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuSong.addMenuItem(new MenuItem("Stream", new CommandStreamSingleSong(song, this)));
        menuSong.addMenuItem(new MenuItem("Add to Favorites", new CommandAddSingleSongToFavoritesProcess(song, this)));
        menuSong.addMenuItem(new MenuItem("Add to Playlists", new CommandAddSingleSongToPlaylistProcess(song, this)));
        menuSong.addMenuItem(new MenuItem("Delete this Song", new CommandDeleteLocalSong(song, this)));
        menuSong.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSong.runMenu();
    }

    @Override
    public void navigate() {
        displayLocalSongMenu();
    }
}
