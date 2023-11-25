package menu.features.exitCommand;

import menu.template.Command;
import menu.template.NavigateExit;
import menu.template.Navigator;

public class CommandOpenNextTime implements Command {
    @Override
    public void execute() {
        Navigator exitScreen = new NavigateExit();
        exitScreen.navigate();
    }
}
