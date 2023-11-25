package menu.features.deleteLocalSong;

import entity.Song;
import menu.template.Command;
import menu.template.NavigateLocalLibrary;
import menu.template.Navigator;
import services.AllArtistsListManagement;
import services.AllGenreListManagement;
import services.AllPlaylistsListManagement;
import services.AllSongsListManagement;
import services.GenreSongListManagement;
import services.LocalArtistSongManagement;
import services.observer.Observer;
import services.observer.Subject;

public class CommandDeleteLocalSongProcess extends Subject implements Command {
    private Song song;

    public CommandDeleteLocalSongProcess(Song song) {
        this.song = song;
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
        AllSongsListManagement.getInstance().getSongs().remove(song);
        System.out.println(song.toString() + " has been deleted from local library and all playlists!");
        notifyObserver();
        removeAll();
        Navigator navigator = new NavigateLocalLibrary();
        navigator.navigate();
    }
}
