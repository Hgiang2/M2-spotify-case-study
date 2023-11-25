package menu.features.addToFavorites.chainAddSingle;

import entity.Favorites;
import entity.Song;
import menu.template.NavigateWantToRemoveFromFavorites;
import menu.template.Navigator;
import menu.features.addToFavorites.addSingle.HandleAddSingleToFavorites;
import services.validator.ValidateCheckSongExistInList;
import services.validator.Validator;

public class HandlerCheckSongExisted implements HandleAddSingleToFavorites {
    private HandleAddSingleToFavorites next;
    private Navigator navigateBack;

    public HandlerCheckSongExisted(HandleAddSingleToFavorites next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(Song song) {
        Validator validator = new ValidateCheckSongExistInList(song, Favorites.getInstance().getSongsInPlaylist());
        return !validator.isCheck();
    }

    @Override
    public void handle(Song song) {
        if (!doHandle(song)) {
            System.out.println("This song has already existed in Favorites!");
            Navigator navigator = new NavigateWantToRemoveFromFavorites(song, navigateBack);
            navigator.navigate();
            return;
        }
        if (next != null) {
            next.handle(song);
        }
    }
}
