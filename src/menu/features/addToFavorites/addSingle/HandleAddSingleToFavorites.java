package menu.features.addToFavorites.addSingle;

import entity.Song;

public interface HandleAddSingleToFavorites {
    boolean doHandle(Song song);
    void handle(Song song);
}
