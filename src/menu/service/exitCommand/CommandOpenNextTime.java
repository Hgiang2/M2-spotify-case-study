package menu.service.exitCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateExit;
import menu.menuCommand.Navigator;

public class CommandOpenNextTime implements Command {
    @Override
    public void execute() {
        Navigator exitScreen = new NavigateExit();
        exitScreen.navigate();
    }
}
