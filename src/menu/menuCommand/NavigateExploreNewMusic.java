package menu.menuCommand;

import constant.Constants;
import menu.service.mainMenuCommand.searchNewMusic.CommandSearchNewMusicProcess;

public class NavigateExploreNewMusic implements Navigator{
    @Override
    public void navigate() {
        Menu menuExploreNewMusic = new MenuInputTemplate("Explore New Music", "Let's find you a new song!");
        menuExploreNewMusic.addMenuItem(new MenuItem(Constants.BLANK, new CommandSearchNewMusicProcess()));
    }
}
