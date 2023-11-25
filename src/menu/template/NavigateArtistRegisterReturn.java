package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;

public class NavigateArtistRegisterReturn implements Navigator{
    private void displayMenuReturn() {
        Menu menu = new MenuTemplate("Done Register", "You will receive notification soon!");
        menu.addMenuItem(new MenuItem(Constants.RETURN, new CommandBack(new NavigateMenuStart())));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayMenuReturn();
    }
}
