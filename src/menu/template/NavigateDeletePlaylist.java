package menu.template;

import entity.Playlist;
import menu.features.deletePlaylist.CommandDeletePlaylistProcess;
import menu.features.exitCommand.CommandBack;

public class NavigateDeletePlaylist implements Navigator{
    private Playlist playlist;
    private Navigator navigateBack;

    public NavigateDeletePlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    private void displayDeletePlaylistProcess() {
        Menu menu = new MenuTemplate("Delete playlist", "Are you sure that you want to delete this playlist?");
        menu.addMenuItem(new MenuItem("Yes", new CommandDeletePlaylistProcess(playlist, new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem("No", new CommandBack(new NavigateSelectPlaylist(playlist, navigateBack))));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayDeletePlaylistProcess();
    }
}
