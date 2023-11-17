package menu.service;

import menu.menuCommand.Command;
import menu.menuCommand.Navigator;
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

    }
}
