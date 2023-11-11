package menu.menuCommand;

import constant.Constants;
import menu.service.userCommand.logInCommand.CommandLogInProcess;

public class NavigateMenuLogIn implements Navigator {
    private void displayMenuLogIn() {
        Menu menuLogIn = new MenuInputTemplate(Constants.LOG_IN_MENU_TITLE, Constants.LOG_IN_MENU_DESCRIPTION);

        menuLogIn.addMenuItem(new MenuItem(Constants.BLANK, new CommandLogInProcess()));
        menuLogIn.runMenu();
    }
    @Override
    public void navigate() {
        displayMenuLogIn();
    }
}
