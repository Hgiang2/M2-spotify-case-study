package menu.template;

import entity.Song;
import menu.features.deleteLocalSong.CommandDeleteLocalSongProcess;
import menu.features.exitCommand.CommandBack;

public class NavigateWantToDeleteThisSong implements Navigator {
    private Song song;
    private Navigator navigateBack;

    public NavigateWantToDeleteThisSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    private void displayDeleteSongMenu() {
        Menu menu = new MenuTabTemplate("Delete song", "Do you want to delete this song permanently?");
        menu.addMenuItem(new MenuItem("Yes", new CommandDeleteLocalSongProcess(song)));
        menu.addMenuItem(new MenuItem("No", new CommandBack(navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayDeleteSongMenu();
    }
}
