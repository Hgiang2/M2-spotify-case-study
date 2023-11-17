package menu.service.addToFavoritesCommand.chain;

import menu.menuCommand.NavigateSpotifyArtistSelected;
import menu.menuCommand.Navigator;
import menu.service.addToFavoritesCommand.HandlerMultipleChoice;
import services.AllSongListManagement;

public class HandlerNavigateBack implements HandlerMultipleChoice {
    private HandlerMultipleChoice next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandlerMultipleChoice next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        System.out.println();
        System.out.println("Added to Favorites successfully!");
        Navigator navigator = new NavigateSpotifyArtistSelected(listManagement.getTitle(), navigateBack);
        navigator.navigate();
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, String choice) {
        if (!doHandle(listManagement, choice)) {
            return;
        }
        if (next != null) {
            next.handle(listManagement, choice);
        }
    }
}
