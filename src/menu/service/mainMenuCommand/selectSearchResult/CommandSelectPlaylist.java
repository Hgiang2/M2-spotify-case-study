package menu.service.mainMenuCommand.selectSearchResult;

import entity.Playlist;
import menu.menuCommand.Command;
import menu.menuCommand.NavigatePlaylistSelected;
import menu.menuCommand.Navigator;

public class CommandSelectPlaylist implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandSelectPlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigatePlaylistSelected(playlist, navigateBack);
        navigator.navigate();
    }
}
