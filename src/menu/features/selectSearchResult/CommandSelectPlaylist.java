package menu.features.selectSearchResult;

import entity.Playlist;
import menu.template.Command;
import menu.template.NavigateSelectPlaylist;
import menu.template.Navigator;

public class CommandSelectPlaylist implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandSelectPlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectPlaylist(playlist, navigateBack);
        navigator.navigate();
    }
}
