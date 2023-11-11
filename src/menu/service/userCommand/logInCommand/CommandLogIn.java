package menu.service.userCommand.logInCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateMenuLogIn;
import menu.menuCommand.Navigator;

public class CommandLogIn implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuLogIn();
        navigator.navigate();
    }
}
