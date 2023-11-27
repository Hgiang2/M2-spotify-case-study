package menu.features.userCommand.logInCommand;

import menu.features.Command;
import menu.template.NavigateMenuLogIn;
import menu.template.Navigator;

public class CommandLogIn implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuLogIn();
        navigator.navigate();
    }
}
