package menu.features.selectSearchResult;

import entity.Song;
import menu.template.Command;
import menu.template.NavigateSelectLocalSong;
import menu.template.Navigator;

public class CommandSelectLocalSong implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandSelectLocalSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectLocalSong(song, navigateBack);
        navigator.navigate();
    }
}
