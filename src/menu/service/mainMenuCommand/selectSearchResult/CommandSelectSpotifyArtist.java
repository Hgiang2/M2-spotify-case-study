package menu.service.mainMenuCommand.selectSearchResult;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateSpotifyArtistSelected;
import menu.menuCommand.Navigator;

public class CommandSelectSpotifyArtist implements Command {
    private Navigator navigateBack;
    private String artist;

    public CommandSelectSpotifyArtist(String artist, Navigator navigateBack) {
        this.artist = artist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSpotifyArtistSelected(artist, navigateBack);
        navigator.navigate();
    }
}
