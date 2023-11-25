package menu.template;

import constant.Constants;
import menu.features.download.CommandDownloadMultipleSongProcess;
import services.AllSongListManagement;

public class NavigateChooseMultipleSongToDownload implements Navigator{
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public NavigateChooseMultipleSongToDownload(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    private void displayListToChoose() {
        Menu menu = new MenuInputListTemplate(listManagement, "Choose multiple songs to download: \n" + listManagement.getTitle());
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandDownloadMultipleSongProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayListToChoose();
    }
}
