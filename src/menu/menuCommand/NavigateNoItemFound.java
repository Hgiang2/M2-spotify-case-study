package menu.menuCommand;

import constant.Constants;
import menu.service.exitCommand.CommandBack;

public class NavigateNoItemFound implements Navigator {

    @Override
    public void navigate() {
        Menu menuNotFound = new MenuTemplate("No Item Found", "Not Found!");
        menuNotFound.addMenuItem(new MenuItem("Return to Main", Constants.BACK_TO_MAIN));
        menuNotFound.addMenuItem(new MenuItem("Try again", new CommandBack(new NavigateExploreNewMusic())));
    }
}
