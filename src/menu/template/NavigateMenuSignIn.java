package menu.template;

import constant.Constants;
import menu.features.userCommand.signInCommand.CommandSignInProcess;

public class NavigateMenuSignIn implements Navigator {
    private void displayMenuSignIn() {
        Menu menuSignIn = new MenuInputTemplate(Constants.SIGN_IN_MENU_TITLE, Constants.SIGN_IN_MENU_DESCRIPTION);
        menuSignIn.addMenuItem(new MenuItem(Constants.BLANK, new CommandSignInProcess()));
        menuSignIn.runMenu();
    }

    @Override
    public void navigate() {
        displayMenuSignIn();
    }
}
