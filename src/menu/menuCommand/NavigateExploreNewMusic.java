package menu.menuCommand;

import constant.Constants;

public class NavigateExploreNewMusic implements Navigator{
    private void displayExploreNewMusic(){
        Menu menuExploreNewMusic = new MenuInputTemplate("Explore New Music", "Let's find you a new song!");
        menuExploreNewMusic.addMenuItem(new MenuItem(Constants.BLANK, new CommandSearchNewMusicResult()));
    }
    @Override
    public void navigate() {
        displayExploreNewMusic();
    }
}
