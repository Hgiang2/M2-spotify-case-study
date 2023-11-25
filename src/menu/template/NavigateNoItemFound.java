package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;

public class NavigateNoItemFound implements Navigator {
    private void displayNotFound() {
        Menu menuNotFound = new MenuTemplate("No Item Found", "Not Found!");
        menuNotFound.addMenuItem(new MenuItem("Return to Main", Constants.BACK_TO_MAIN));
        menuNotFound.addMenuItem(new MenuItem("Try again", new CommandBack(new NavigateExploreNewMusic())));
        menuNotFound.runMenu();
    }
    @Override
    public void navigate() {
        displayNotFound();
    }
}
