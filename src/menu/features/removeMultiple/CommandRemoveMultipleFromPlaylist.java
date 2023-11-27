package menu.features.removeMultiple;

import menu.features.Command;
import menu.template.NavigateRemoveMultipleFromPlaylist;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandRemoveMultipleFromPlaylist implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandRemoveMultipleFromPlaylist(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateRemoveMultipleFromPlaylist(listManagement, navigateBack);
        navigator.navigate();
    }
}
