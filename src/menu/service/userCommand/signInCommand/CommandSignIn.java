package menu.service.userCommand.signInCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateMenuSignIn;
import menu.menuCommand.Navigator;

public class CommandSignIn implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuSignIn();
        navigator.navigate();
    }
}
