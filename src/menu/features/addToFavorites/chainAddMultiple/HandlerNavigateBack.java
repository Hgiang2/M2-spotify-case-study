package menu.features.addToFavorites.chainAddMultiple;

import menu.template.NavigateSelectSpotifyArtist;
import menu.template.Navigator;
import menu.features.addToFavorites.addMultiple.HandleAddToFavorites;
import services.AllSongListManagement;

public class HandlerNavigateBack implements HandleAddToFavorites {
    private HandleAddToFavorites next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandleAddToFavorites next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        System.out.println();
        System.out.println("Added to Favorites successfully!");
        Navigator navigator = new NavigateSelectSpotifyArtist(listManagement.getTitle(), navigateBack);
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
