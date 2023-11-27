package menu.features.addToFavorites.addMultiple;

import menu.features.Command;
import menu.template.NavigateAddMultipleToFavorites;
import menu.template.Navigator;
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
