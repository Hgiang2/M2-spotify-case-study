package menu.features.addToFavorites.chainAddMultiple;

import menu.features.addToFavorites.addMultiple.HandleAddToFavorites;
import services.AllPlaylistsListManagement;
import services.AllSongListManagement;
import services.SongInPlaylistManagement;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerUpdate extends Subject implements HandleAddToFavorites {
    private HandleAddToFavorites next;

    public HandlerUpdate(HandleAddToFavorites next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        Observer observerAllPlaylist = AllPlaylistsListManagement.getInstance();
        Observer observerAllLocalSongs = new SongInPlaylistManagement();
        addObserver(observerAllPlaylist);
        addObserver(observerAllLocalSongs);
        notifyObserver();
        removeAll();
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
