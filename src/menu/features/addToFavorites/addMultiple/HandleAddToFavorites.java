package menu.features.addToFavorites.addMultiple;

import services.AllSongListManagement;

public interface HandleAddToFavorites {
    boolean doHandle(AllSongListManagement listManagement, String choice);
    void handle(AllSongListManagement listManagement, String choice);
}

