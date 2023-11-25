package menu.template;

import constant.Constants;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.createPlaylist.CommandCreatePlaylistProcess;

public class NavigateCreatePlaylist implements Navigator {
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public NavigateCreatePlaylist(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    public NavigateCreatePlaylist(Navigator navigateBack) {
        this.navigateBack = navigateBack;
    }

    private void displayCreatePlaylist() {
        Menu menu = new MenuInputTemplate("Create new playlist", "Let's create a new playlist!");
        if (selectedItems != null) {
            menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandCreatePlaylistProcess(selectedItems, navigateBack)));
        } else {
            menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandCreatePlaylistProcess(navigateBack)));
        }
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayCreatePlaylist();
    }
}
