package menu.features.addToPlaylists.selectSongs;

import menu.features.Command;
import menu.template.NavigateAddToPlaylists;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandAddMultipleToPlaylists implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandAddMultipleToPlaylists(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateAddToPlaylists(listManagement, navigateBack);
        navigator.navigate();
    }
}
