package menu.features.yourLibrary;

import menu.features.Command;
import menu.template.NavigateAllSongs;
import menu.template.Navigator;

public class CommandAllSongs implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateAllSongs();
        navigator.navigate();
    }
}
