package menu.features.addToFavorites.addSingle;

import entity.Song;
import menu.template.Command;
import menu.template.Navigator;
import menu.features.addToFavorites.chainAddSingle.HandlerAddSingleToFavorites;
import menu.features.addToFavorites.chainAddSingle.HandlerCheckSongExisted;
import menu.features.addToFavorites.chainAddSingle.HandlerNavigateBack;

public class CommandAddSingleSongToFavoritesProcess implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandAddSingleSongToFavoritesProcess(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleAddSingleToFavorites handlerNavigateBack = new HandlerNavigateBack(null, navigateBack);
        HandleAddSingleToFavorites handleAddSingleToFavorites = new HandlerAddSingleToFavorites(handlerNavigateBack);
        HandleAddSingleToFavorites handlerCheckExisted = new HandlerCheckSongExisted(handleAddSingleToFavorites, navigateBack);

        handlerCheckExisted.handle(song);
    }
}
