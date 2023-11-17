package menu.menuCommand;

import menu.service.addToFavoritesCommand.CommandAddToFavoritesProcess;
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
        menu.addMenuItem(new MenuItem("Type multiple numbers with space between: ", new CommandAddToFavoritesProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayMenuAddMultipleToFavorites();
    }
}
