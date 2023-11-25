package menu.template;

import constant.Constants;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.createPlaylist.CommandCreatePlaylist;
import menu.features.exitCommand.CommandBack;

public class NavigateNoPlaylist implements Navigator {
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public NavigateNoPlaylist(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    private void displayNavigateNoPlaylist() {
        Menu menu = new MenuTemplate("No playlists", "You have no playlists yet! Do you want to create a new one?");
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menu.addMenuItem(new MenuItem("Create new playlist", new CommandCreatePlaylist(selectedItems, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayNavigateNoPlaylist();
    }
}
