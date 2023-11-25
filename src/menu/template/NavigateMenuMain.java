package menu.template;

import constant.Constants;
import menu.features.checkPlan.CommandCheckPlan;
import menu.features.searchCommand.searchNewMusic.CommandExploreNewMusic;
import menu.features.yourLibrary.CommandLocalLibrary;
import entity.CurrentUser;

public class NavigateMenuMain implements Navigator {
    private void displayMenuMain() {
        System.out.println();
        Menu menuMain = new MenuTemplate(Constants.MAIN_MENU_TITLE, "Welcome " + CurrentUser.getInstance().getCurrentUser().getUsername() + "! Let's explore your taste of music with us!");
        menuMain.addMenuItem(new MenuItem(Constants.EXIT, Constants.EXIT_APP));
        menuMain.addMenuItem(new MenuItem("Log out", Constants.BACK_TO_START));
        menuMain.addMenuItem(new MenuItem("Explore new music", new CommandExploreNewMusic()));
        menuMain.addMenuItem(new MenuItem("Your library", new CommandLocalLibrary()));
        menuMain.addMenuItem(new MenuItem("Check your plan", new CommandCheckPlan()));
        menuMain.runMenu();
    }

    @Override
    public void navigate() {
        displayMenuMain();
    }
}
