package menu.features.selectSearchResult;

import entity.Song;
import menu.template.Command;
import menu.template.NavigateSelectSpotifySong;
import menu.template.Navigator;

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
