package menu.features.yourLibrary;

import menu.features.Command;
import menu.template.NavigateLocalLibrary;
import menu.template.Navigator;

public class CommandLocalLibrary implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateLocalLibrary();
        navigator.navigate();
    }
}
