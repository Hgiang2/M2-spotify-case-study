package menu.features.download;

import menu.template.Command;
import menu.template.NavigateChooseMultipleSongToDownload;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandDownloadMultipleSong implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandDownloadMultipleSong(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateChooseMultipleSongToDownload(listManagement, navigateBack);
        navigator.navigate();
    }
}
