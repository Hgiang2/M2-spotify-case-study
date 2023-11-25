package menu.template;

import constant.Constants;
import menu.features.removeMultiple.CommandRemoveMultipleFromPlaylistProcess;
import services.AllSongListManagement;

public class NavigateRemoveMultipleFromPlaylist implements Navigator {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public NavigateRemoveMultipleFromPlaylist(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    private void displayRemoveMultiple() {
        Menu menu = new MenuInputListTemplate(listManagement);
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandRemoveMultipleFromPlaylistProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayRemoveMultiple();
    }
}
