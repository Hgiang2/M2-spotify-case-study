package menu.template;

import constant.Constants;
import menu.features.checkPlan.CommandCheckPlan;
import menu.features.searchCommand.searchNewMusic.CommandExploreNewMusic;
import menu.features.userCommand.CurrentUser;

public class NavigateMenuNormalMain implements Navigator{
    private void displayMenuNormal(){
        Menu menu = new MenuTemplate(Constants.MAIN_MENU_TITLE, "Welcome " + CurrentUser.getInstance().getCurrentUser().getUsername() + "! Let's explore your taste of music with us!");
        menu.addMenuItem(new MenuItem(Constants.EXIT, Constants.EXIT_APP));
        menu.addMenuItem(new MenuItem("Log out", Constants.BACK_TO_START));
        menu.addMenuItem(new MenuItem("Explore new music", new CommandExploreNewMusic()));
        menu.addMenuItem(new MenuItem("Check your plan", new CommandCheckPlan()));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayMenuNormal();
    }
}
