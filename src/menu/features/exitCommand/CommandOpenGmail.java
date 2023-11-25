package menu.features.exitCommand;

import menu.template.Command;
import menu.template.NavigateExit;
import menu.template.NavigateGmail;
import menu.template.Navigator;

public class CommandOpenGmail implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateGmail();
        navigator.navigate();
    }
}
