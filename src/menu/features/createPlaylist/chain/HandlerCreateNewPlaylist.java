package menu.features.createPlaylist.chain;

import entity.Playlist;
import menu.features.createPlaylist.HandlePlaylist;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerCreateNewPlaylist extends Subject implements HandlePlaylist {
    private Playlist playlist;
    private HandlePlaylist next;

    public HandlerCreateNewPlaylist(HandlePlaylist next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(Playlist playlist) {
        Observer observerAllPlaylists = AllPlaylistsListManagement.getInstance();
        addObserver(observerAllPlaylists);
        AllPlaylistsListManagement.getInstance().getAllPlaylists().add(playlist);
        notifyObserver();
        removeAll();
        return true;
    }

    @Override
    public void handle(Playlist playlist) {
        if (!doHandle(playlist)) {
            return;
        }
        if (next != null) {
            System.out.println("Playlist " + playlist + " has been created successfully!");
            next.handle(playlist);
        }
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}
