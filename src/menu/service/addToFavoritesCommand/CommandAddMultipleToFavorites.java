package menu.service.addToFavoritesCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateAddMultipleToFavorites;
import menu.menuCommand.Navigator;
import services.AllSongListManagement;

public class CommandAddMultipleToFavorites implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandAddMultipleToFavorites(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateAddMultipleToFavorites(listManagement, navigateBack);
        navigator.navigate();
    }
}
