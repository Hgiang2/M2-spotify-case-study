package menu.features.editPlaylist;

import entity.Playlist;
import menu.features.Command;
import menu.template.NavigateEditPlaylist;
import menu.template.Navigator;

public class CommandEditPlaylist implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandEditPlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateEditPlaylist(playlist, navigateBack);
        navigator.navigate();
    }
}
