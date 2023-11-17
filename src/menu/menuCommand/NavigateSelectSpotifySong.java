package menu.menuCommand;

import constant.Constants;
import entity.Song;
import menu.service.exitCommand.CommandBack;
import menu.service.mainMenuCommand.selectSearchResult.CommandStreamSong;

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
        menuSpotifySong.addMenuItem(new MenuItem("Play/Stop", new CommandStreamSong(song)));
//        menuSpotifySong.addMenuItem(new MenuItem("Add to Favorites", new CommandAddSongToFavorites(song)));
//        menuSpotifySong.addMenuItem(new MenuItem("Add to Playlists", new CommandAddToPlaylists(song)));
        menuSpotifySong.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSpotifySong.runMenu();
    }

    @Override
    public void navigate() {
        displaySelectSpotifySongMenu();
    }
}
