package menu.template;

import constant.Constants;
import menu.features.addToFavorites.addMultiple.CommandAddToFavoritesProcess;
import services.AllSongListManagement;

public class NavigateAddMultipleToFavorites implements Navigator {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public NavigateAddMultipleToFavorites(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    private void displayMenuAddMultipleToFavorites() {
        Menu menu = new MenuInputListTemplate(listManagement);
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandAddToFavoritesProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayMenuAddMultipleToFavorites();
    }
}
