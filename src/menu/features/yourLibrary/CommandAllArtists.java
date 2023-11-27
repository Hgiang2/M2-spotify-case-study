package menu.features.yourLibrary;

import menu.features.Command;
import menu.template.NavigateAllLocalArtists;
import menu.template.Navigator;

public class CommandAllArtists implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateAllLocalArtists();
        navigator.navigate();
    }
}
