package menu.features.yourLibrary;

import menu.template.Command;
import menu.template.NavigateAllLocalArtists;
import menu.template.Navigator;

public class CommandAllArtists implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateAllLocalArtists();
        navigator.navigate();
    }
}
