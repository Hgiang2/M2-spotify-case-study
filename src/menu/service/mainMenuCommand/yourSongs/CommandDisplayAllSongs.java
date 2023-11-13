package menu.service.mainMenuCommand.yourSongs;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateExploreNewMusic;
import menu.menuCommand.Navigator;

public class CommandDisplayAllSongs implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateDisplayAllSongs();
        navigator.navigate();
    }
}
