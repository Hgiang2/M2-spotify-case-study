package menu.features.exitCommand;

import menu.features.Command;
import menu.template.NavigateExit;
import menu.template.Navigator;

public class CommandExit implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateExit();
        navigator.navigate();
    }
}
