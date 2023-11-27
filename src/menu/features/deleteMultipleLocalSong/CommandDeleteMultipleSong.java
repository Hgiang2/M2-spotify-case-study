package menu.features.deleteMultipleLocalSong;

import menu.features.Command;
import menu.template.NavigateDeleteMultipleLocalSong;
import menu.template.Navigator;

public class CommandDeleteMultipleSong implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateDeleteMultipleLocalSong();
        navigator.navigate();
    }
}
