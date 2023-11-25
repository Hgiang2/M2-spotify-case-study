package menu.features.removeMultiple;

import entity.Favorites;
import entity.Song;
import menu.template.Command;
import menu.template.Navigator;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

import java.util.List;

public class CommandRemoveFromFavorites extends Subject implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandRemoveFromFavorites(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        addObserver(observeAllPlaylist);
        List<Song> favorites = Favorites.getInstance().getSongsInPlaylist();
        for (int i = 0; i < favorites.size(); i++) {
            if (favorites.get(i).getName().equals(song.getName())) {
                favorites.remove(favorites.get(i));
                break;
            }
        }
        notifyObserver();
        removeAll();
        System.out.println("This song has been removed from Favorites...");
        navigateBack.navigate();
    }
}
