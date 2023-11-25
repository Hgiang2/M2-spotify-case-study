package menu.features.addToFavorites.chainAddSingle;

import entity.Song;
import menu.template.Navigator;
import menu.features.addToFavorites.addSingle.HandleAddSingleToFavorites;

public class HandlerNavigateBack implements HandleAddSingleToFavorites {
    private HandleAddSingleToFavorites next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandleAddSingleToFavorites next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(Song song) {
        System.out.println("This song has been added to Favorites successfully!");
        navigateBack.navigate();
        return true;
    }

    @Override
    public void handle(Song song) {
        if (!doHandle(song)) {
            return;
        }
        if (next != null) {
            next.handle(song);
        }
    }
}
