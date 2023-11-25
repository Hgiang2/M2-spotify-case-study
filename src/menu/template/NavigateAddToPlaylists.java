package menu.template;

import constant.Constants;
import menu.features.addToPlaylists.selectSongs.CommandAddToPlaylistsProcess;
import services.AllSongListManagement;

public class NavigateAddToPlaylists implements Navigator{
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public NavigateAddToPlaylists(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    private void displayAddToPlaylists() {
        Menu menu = new MenuInputListTemplate(listManagement);
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandAddToPlaylistsProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayAddToPlaylists();
    }
}
