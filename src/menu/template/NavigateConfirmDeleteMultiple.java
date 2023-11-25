package menu.template;

import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.deleteMultipleLocalSong.CommandDeleteMultipleConfirm;
import menu.features.exitCommand.CommandBack;

public class NavigateConfirmDeleteMultiple implements Navigator{
    private SelectedItems selectedItems;

    public NavigateConfirmDeleteMultiple(SelectedItems selectedItems) {
        this.selectedItems = selectedItems;
    }

    private void displayConfirmDeleteMultiple() {
        Menu menu = new MenuTemplate("Confirm Delete Multiple", "Do you want to delete these songs permanently?");
        menu.addMenuItem(new MenuItem("Yes", new CommandDeleteMultipleConfirm(selectedItems)));
        menu.addMenuItem(new MenuItem("No", new CommandBack(new NavigateAllSongs())));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayConfirmDeleteMultiple();
    }
}
