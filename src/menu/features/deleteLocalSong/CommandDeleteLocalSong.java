package menu.features.deleteLocalSong;

import entity.Song;
import menu.template.NavigateWantToDeleteThisSong;
import menu.features.Command;
import menu.template.Navigator;

public class CommandDeleteLocalSong implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandDeleteLocalSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateWantToDeleteThisSong(song, navigateBack);
        navigator.navigate();
    }
}
