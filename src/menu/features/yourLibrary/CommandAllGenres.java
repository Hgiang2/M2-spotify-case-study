package menu.features.yourLibrary;

import menu.features.Command;
import menu.template.NavigateAllGenres;
import menu.template.Navigator;

public class CommandAllGenres implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateAllGenres();
        navigator.navigate();
    }
}
