package menu.template;

import constant.Constants;
import menu.features.searchCommand.searchNewMusic.CommandSearchNewMusicProcess;

public class NavigateExploreNewMusic implements Navigator{
    private void displayExploreNewMusic(){
        Menu menuExploreNewMusic = new MenuInputTemplate("Explore New Music", "Let's find you a new song!");
        menuExploreNewMusic.addMenuItem(new MenuItem(Constants.BLANK, new CommandSearchNewMusicProcess()));
        menuExploreNewMusic.runMenu();
    }
    @Override
    public void navigate() {
        displayExploreNewMusic();
    }
}
