package menu.service.addToFavoritesCommand.chain;

import menu.service.addToFavoritesCommand.HandlerMultipleChoice;
import services.AllSongListManagement;

public class HandlerAddMultipleToFavorites implements HandlerMultipleChoice {
    private HandlerMultipleChoice next;

    public HandlerAddMultipleToFavorites(HandlerMultipleChoice next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        listManagement.addMultipleToFavorites(choice);
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
