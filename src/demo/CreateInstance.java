package demo;

import entity.Favorites;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

public class CreateInstance extends Subject {
    public void execute() {
        Observer observeAllPlaylists = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylists);
        Favorites.getInstance();
        notifyObserver();
        removeAll();
    }
}
