package menu.template;

import constant.Constants;
import menu.features.addToPlaylists.selectPlaylists.CommandSelectMultiplePlaylistProcess;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class NavigateDisplayAllPlaylistsToChoose implements Navigator{
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public NavigateDisplayAllPlaylistsToChoose(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    private void displayPlaylists() {
        Menu menu = new MenuChooseMultiplePlaylistTemplate("Choose one or multiple playlists to add songs: ");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandSelectMultiplePlaylistProcess(selectedItems, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayPlaylists();
    }
}
