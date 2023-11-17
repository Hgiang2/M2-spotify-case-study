package menu.service.addToFavoritesCommand;

import services.AllSongListManagement;

public interface HandlerMultipleChoice {
    boolean doHandle(AllSongListManagement listManagement, String choice);
    void handle(AllSongListManagement listManagement, String choice);
}
