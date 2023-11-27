package menu.features.selectSearchResult;

import entity.Artist;
import menu.features.Command;
import menu.template.NavigateSelectLocalArtist;
import menu.template.Navigator;

public class CommandSelectArtist implements Command {
    private Navigator navigateBack;
    private Artist artist;

    public CommandSelectArtist(Artist artist, Navigator navigateBack) {
        this.navigateBack = navigateBack;
        this.artist = artist;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectLocalArtist(artist, navigateBack);
        navigator.navigate();
    }
}
