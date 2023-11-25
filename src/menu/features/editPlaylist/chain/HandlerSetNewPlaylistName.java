package menu.features.editPlaylist.chain;

import entity.Playlist;
import menu.features.editPlaylist.HandleEditPlaylist;
import menu.template.CommandInput;
import menu.features.createPlaylist.CommandInputPlaylistName;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

public class HandlerSetNewPlaylistName extends Subject implements HandleEditPlaylist {
    private HandleEditPlaylist next;

    public HandlerSetNewPlaylistName(HandleEditPlaylist next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String name, Playlist playlist) {
        for (Playlist playlists : AllPlaylistsListManagement.getInstance().getAllPlaylists()) {
            if (name.equals(playlists.getName())) return false;
        }
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylist);
        playlist.setName(name);
        notifyObserver();
        removeAll();
        return true;
    }

    @Override
    public void handle(String name, Playlist playlist) {
        while (!doHandle(name, playlist)) {
            System.out.println("This playlist name has already exist!");
            CommandInput nameReEnter = new CommandInputPlaylistName("Please enter another name: ");
            nameReEnter.execute();
            name = nameReEnter.getInput();
        }
        if (next != null) {
            next.handle(name, playlist);
        }
    }
}
