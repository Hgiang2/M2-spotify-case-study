package menu.service.exitCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateExit;
import menu.menuCommand.Navigator;

public class CommandExit implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateExit();
        navigator.navigate();
    }
}
