package menu.features.searchCommand.searchNewMusic;

import menu.features.Command;
import menu.template.NavigateExploreNewMusic;
import menu.template.Navigator;

public class CommandExploreNewMusic implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateExploreNewMusic();
        navigator.navigate();
    }
}
