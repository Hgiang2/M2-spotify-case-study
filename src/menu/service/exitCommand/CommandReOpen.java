package menu.service.exitCommand;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateMenuStart;
import menu.menuCommand.Navigator;

public class CommandReOpen implements Command {
    @Override
    public void execute() {
        Navigator navigatorStart = new NavigateMenuStart();
        navigatorStart.navigate();
    }
}
