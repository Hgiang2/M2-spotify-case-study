package menu.features.registerArtist;

import menu.features.Command;
import menu.template.NavigateEnterStageName;
import menu.template.Navigator;

public class CommandArtistRegister implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateEnterStageName();
        navigator.navigate();
    }
}
