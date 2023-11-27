package menu.features.deleteMultipleLocalSong;

import entity.Song;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.Command;
import menu.template.NavigateAllSongs;
import menu.template.Navigator;
import services.AllArtistsListManagement;
import services.AllGenreListManagement;
import services.AllPlaylistsListManagement;
import services.AllSongsListManagement;
import services.GenreSongListManagement;
import services.LocalArtistSongManagement;
import services.observer.Observer;
import services.observer.Subject;

import java.util.List;

public class CommandDeleteMultipleConfirm extends Subject implements Command {
    private SelectedItems selectedItems;

    public CommandDeleteMultipleConfirm(SelectedItems selectedItems) {
        this.selectedItems = selectedItems;
    }

    @Override
    public void execute() {
        Observer observeAll = AllSongsListManagement.getInstance();
        Observer observeAllPlaylist = AllPlaylistsListManagement.getInstance();
        Observer observeGenreSong = new GenreSongListManagement();
        Observer observeAllGenre = AllGenreListManagement.getInstance();
        Observer observeArtistSong = new LocalArtistSongManagement();
        Observer observeAllArtist = AllArtistsListManagement.getInstance();
        addObserver(observeAll);
        addObserver(observeAllPlaylist);
        addObserver(observeGenreSong);
        addObserver(observeAllGenre);
        addObserver(observeArtistSong);
        addObserver(observeAllArtist);
        List<Song> allSongs = AllSongsListManagement.getInstance().getSongs();
        for (int i = 0; i < allSongs.size(); i++) {
            allSongs.remove(allSongs.get(i));
        }
        notifyObserver();
        removeAll();
        System.out.println("Delete songs from both local and playlists successfully!");

        Navigator navigator = new NavigateAllSongs();
        navigator.navigate();
    }
}
