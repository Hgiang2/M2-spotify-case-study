package menu.template;

import constant.Constants;
import menu.features.deleteMultipleLocalSong.CommandDeleteMultipleSongProcess;

public class NavigateDeleteMultipleLocalSong implements Navigator{
    private void displayAllSongsToDelete() {
        Menu menu = new MenuInputTemplate("Delete local songs", "Choose one or multiple songs to delete ");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandDeleteMultipleSongProcess()));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayAllSongsToDelete();
    }
}
