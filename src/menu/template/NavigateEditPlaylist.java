package menu.template;

import constant.Constants;
import entity.Playlist;
import menu.features.editPlaylist.CommandEditPlaylistProcess;

public class NavigateEditPlaylist implements Navigator{
    private Playlist playlist;
    private Navigator navigateBack;

    public NavigateEditPlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    private void displayEditPlaylist() {
        Menu menu = new MenuInputTemplate("Edit playlist", "Edit playlist" + playlist.getName() + ".....");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandEditPlaylistProcess(playlist, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayEditPlaylist();
    }
}
