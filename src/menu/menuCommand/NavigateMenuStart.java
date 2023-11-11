package menu.menuCommand;

import constant.Constants;
import menu.service.exitCommand.CommandExit;
import menu.service.userCommand.logInCommand.CommandLogIn;
import menu.service.userCommand.signInCommand.CommandSignIn;

public class NavigateMenuStart implements Navigator{
    private void displayMenuStart(){
        Menu menuStart = new MenuTemplate(Constants.USER_START_MENU_TITLE, Constants.USER_START_MENU_DESCRIPTION);
        menuStart.addMenuItem(new MenuItem(Constants.EXIT, new CommandExit()));
        menuStart.addMenuItem(new MenuItem("New to Spotify", new CommandSignIn()));
        menuStart.addMenuItem(new MenuItem("An existed user", new CommandLogIn()));
        menuStart.runMenu();
    }
    @Override
    public void navigate() {
        displayMenuStart();
    }
}
