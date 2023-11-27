package menu.features.exitCommand;

import menu.features.Command;
import menu.template.NavigateGmail;
import menu.template.Navigator;

public class CommandOpenGmail implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateGmail();
        navigator.navigate();
    }
}
