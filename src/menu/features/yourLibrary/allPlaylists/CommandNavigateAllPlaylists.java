package menu.features.yourLibrary.allPlaylists;

import menu.template.Command;
import menu.template.NavigateAllPlaylists;
import menu.template.NavigateDisplayAllPlaylistsToChoose;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class CommandNavigateAllPlaylists implements Command {
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public CommandNavigateAllPlaylists(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    public CommandNavigateAllPlaylists() {
    }

    @Override
    public void execute() {
        if (selectedItems == null) {
            Navigator navigator = new NavigateAllPlaylists();
            navigator.navigate();
        } else {
            Navigator navigator = new NavigateDisplayAllPlaylistsToChoose(selectedItems, navigateBack);
            navigator.navigate();
        }
    }
}
