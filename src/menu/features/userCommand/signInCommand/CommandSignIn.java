package menu.features.userCommand.signInCommand;

import menu.features.Command;
import menu.template.NavigateMenuSignIn;
import menu.template.Navigator;

public class CommandSignIn implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuSignIn();
        navigator.navigate();
    }
}
