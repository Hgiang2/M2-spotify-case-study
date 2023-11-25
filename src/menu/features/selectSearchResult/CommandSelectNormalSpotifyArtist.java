package menu.features.selectSearchResult;

import entity.Artist;
import menu.template.Command;
import menu.template.NavigateSelectNormalSpotifyArtist;
import menu.template.Navigator;

public class CommandSelectNormalSpotifyArtist implements Command {
    private Artist artist;
    private Navigator navigateBack;

    public CommandSelectNormalSpotifyArtist(Artist artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectNormalSpotifyArtist(artist, navigateBack);
        navigator.navigate();
    }
}
