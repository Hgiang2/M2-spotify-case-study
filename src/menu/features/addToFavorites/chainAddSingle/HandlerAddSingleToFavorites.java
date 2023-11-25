package menu.features.addToFavorites.chainAddSingle;

import entity.Favorites;
import entity.Song;
import menu.features.addToFavorites.addSingle.HandleAddSingleToFavorites;
import services.AllPlaylistsListManagement;
import services.SongInPlaylistManagement;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerAddSingleToFavorites extends Subject implements HandleAddSingleToFavorites {
    private HandleAddSingleToFavorites next;

    public HandlerAddSingleToFavorites(HandleAddSingleToFavorites next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Song song) {
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        Observer observeAllSongs = new SongInPlaylistManagement();
        addObserver(observeAllPlaylist);
        addObserver(observeAllSongs);
        Favorites.getInstance().getSongsInPlaylist().add(song);
        song.setTime(System.currentTimeMillis());
        notifyObserver();
        removeAll();
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
