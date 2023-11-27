package menu.features.addLocalSongsToPlaylist;

import entity.Playlist;
import menu.features.Command;
import menu.template.NavigateChooseLocalSongs;
import menu.template.Navigator;

public class CommandAddLocalSongsToPlaylist implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandAddLocalSongsToPlaylist(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateChooseLocalSongs(playlist, navigateBack);
        navigator.navigate();
    }
}
