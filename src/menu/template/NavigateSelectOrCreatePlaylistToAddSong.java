package menu.template;

import constant.Constants;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.yourLibrary.allPlaylists.CommandNavigateAllPlaylists;
import menu.features.createPlaylist.CommandCreatePlaylist;
import menu.features.exitCommand.CommandBack;

public class NavigateSelectOrCreatePlaylistToAddSong implements Navigator{
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public NavigateSelectOrCreatePlaylistToAddSong(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    private void displaySelectOrCreatePlaylist() {
        Menu menu = new MenuTemplate("Add to Existed Playlist or Create New", "Add your songs to...");
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menu.addMenuItem(new MenuItem("Existing Playlists", new CommandNavigateAllPlaylists(selectedItems, this)));
        menu.addMenuItem(new MenuItem("Create a new Playlist", new CommandCreatePlaylist(selectedItems, this)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displaySelectOrCreatePlaylist();
    }
}
