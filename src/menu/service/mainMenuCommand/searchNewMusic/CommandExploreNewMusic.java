package menu.service.mainMenuCommand.searchNewMusic;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateExploreNewMusic;
import menu.menuCommand.Navigator;

public class CommandExploreNewMusic implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateExploreNewMusic();
        navigator.navigate();
    }
}
