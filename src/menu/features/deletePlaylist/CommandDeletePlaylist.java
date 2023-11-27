package menu.features.deletePlaylist;

import entity.Playlist;
import menu.features.Command;
import menu.template.NavigateDeletePlaylist;
import menu.template.Navigator;

public class CommandDeletePlaylist implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandDeletePlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateDeletePlaylist(playlist, navigateBack);
        navigator.navigate();
    }
}
