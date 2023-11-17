package menu.menuCommand;

import constant.Constants;
import entity.Song;
import menu.service.exitCommand.CommandBack;

public class NavigateSongSelected implements Navigator {
    private Song song;
    private Navigator navigateBack;

    public NavigateSongSelected(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    private void DisplaySongMenu() {
        Menu menuSong = new MenuTemplate(song.getName(), song.toString());
        System.out.println();
        menuSong.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
//        menuSong.addMenuItem(new MenuItem(Constants.STREAM, new CommandStreamSong(song)));
//        menuSong.addMenuItem(new MenuItem("Add to Favorites", new CommandAddToFavorites(song)));
//        menuSong.addMenuItem(new MenuItem("Add to Playlists", new CommandAddToPlaylists(song)));
//        menuSong.addMenuItem(new MenuItem("Delete song", new CommandDeleteSong(song)));
        menuSong.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuSong.runMenu();
    }

    @Override
    public void navigate() {
        DisplaySongMenu();
    }
}
