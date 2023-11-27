package menu.features.createPlaylist;

import menu.template.NavigateCreatePlaylist;
import menu.features.Command;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;

public class CommandCreatePlaylist implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;
    private SelectedItems selectedItems;

    public CommandCreatePlaylist(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    public CommandCreatePlaylist(Navigator navigateBack) {
        this.navigateBack = navigateBack;
    }

    public CommandCreatePlaylist(SelectedItems selectedItems, Navigator navigateBack) {
        this.navigateBack = navigateBack;
        this.selectedItems = selectedItems;
    }

    @Override
    public void execute() {
        if (selectedItems != null) {
            Navigator navigator = new NavigateCreatePlaylist(selectedItems, navigateBack);
            navigator.navigate();
        } else {
            Navigator navigator = new NavigateCreatePlaylist(navigateBack);
            navigator.navigate();
        }
    }
}
