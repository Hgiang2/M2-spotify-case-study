package menu.features.selectSearchResult;

import entity.Artist;
import menu.features.Command;
import menu.template.NavigateSelectSpotifyArtist;
import menu.template.Navigator;

public class CommandSelectSpotifyArtist implements Command {
    private Navigator navigateBack;
    private Artist artist;

    public CommandSelectSpotifyArtist(Artist artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectSpotifyArtist(artist.getStageName(), navigateBack);
        navigator.navigate();
    }
}
