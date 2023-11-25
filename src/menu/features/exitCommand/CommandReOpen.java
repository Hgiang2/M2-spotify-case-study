package menu.features.exitCommand;

import menu.template.Command;
import menu.template.NavigateMenuStart;
import menu.template.Navigator;

public class CommandReOpen implements Command {
    @Override
    public void execute() {
        Navigator navigatorStart = new NavigateMenuStart();
        navigatorStart.navigate();
    }
}
