package menu.features.userCommand.signInCommand;

import menu.template.Command;
import menu.template.NavigateMenuSignIn;
import menu.template.Navigator;

public class CommandSignIn implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuSignIn();
        navigator.navigate();
    }
}
