package menu.features.selectSearchResult;

import entity.Song;
import menu.template.Command;
import menu.template.NavigateSelectNormalSpotifySong;
import menu.template.Navigator;

public class CommandSelectNormalSpotifySong implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandSelectNormalSpotifySong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectNormalSpotifySong(song, navigateBack);
        navigator.navigate();
    }
}
