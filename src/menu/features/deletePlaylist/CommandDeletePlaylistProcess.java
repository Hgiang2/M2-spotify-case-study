package menu.features.deletePlaylist;

import entity.Playlist;
import menu.template.Command;
import menu.template.Navigator;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

import java.util.List;

public class CommandDeletePlaylistProcess extends Subject implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandDeletePlaylistProcess(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylist);
        List<Playlist> allPlaylists = AllPlaylistsListManagement.getInstance().getAllPlaylists();
        for (int i = 0; i < allPlaylists.size(); i++) {
            if(playlist.getName().equals(allPlaylists.get(i).getName())) {
                allPlaylists.remove(allPlaylists.get(i));
                break;
            }
        }
        notifyObserver();
        removeAll();

        navigateBack.navigate();
    }
}
