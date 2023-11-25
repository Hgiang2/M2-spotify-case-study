package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;

public class NavigateNoItemFoundLocal implements Navigator{
    private void displayNotFoundLocal() {
        Menu menuNotFound = new MenuTemplate("No Local Item Found", "Not Found!");
        menuNotFound.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menuNotFound.addMenuItem(new MenuItem("Try again", new CommandBack(new NavigateSearchLocalLibrary())));
        menuNotFound.runMenu();
    }
    @Override
    public void navigate() {
        displayNotFoundLocal();
    }
}
