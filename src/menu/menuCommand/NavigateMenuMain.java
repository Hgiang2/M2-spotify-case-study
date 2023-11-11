package menu.menuCommand;

import constant.Constants;
import menu.service.mainMenuCommand.searchNewMusic.CommandExploreNewMusic;
import menu.service.userCommand.CurrentUser;

public class NavigateMenuMain implements Navigator {
    private void displayMenuMain() {
        System.out.println();
        Menu menuMain = new MenuTemplate(Constants.MAIN_MENU_TITLE, "Welcome " + CurrentUser.getInstance().getCurrentUser().getUsername() + "! Let's explore your taste of music with us!");
        menuMain.addMenuItem(new MenuItem(Constants.EXIT, Constants.EXIT_APP));
        menuMain.addMenuItem(new MenuItem("Log out", Constants.BACK_TO_START));
        menuMain.addMenuItem(new MenuItem("Explore new music", new CommandExploreNewMusic()));
        menuMain.addMenuItem(new MenuItem("Search your library", new CommandSearchLocal()));
        menuMain.addMenuItem(new MenuItem("Your songs", new CommandAllSongs()));
        menuMain.addMenuItem(new MenuItem("Your playlists", new CommandAllPlaylists()));
        menuMain.runMenu();
    }

    @Override
    public void navigate() {
        displayMenuMain();
    }
}
