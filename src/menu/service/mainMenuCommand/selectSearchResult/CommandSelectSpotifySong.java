package menu.service.mainMenuCommand.selectSearchResult;

import entity.Song;
import menu.menuCommand.Command;
import menu.menuCommand.NavigateSelectSpotifySong;
import menu.menuCommand.Navigator;

public class CommandSelectSpotifySong implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandSelectSpotifySong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectSpotifySong(song, navigateBack);
        navigator.navigate();
    }
}
