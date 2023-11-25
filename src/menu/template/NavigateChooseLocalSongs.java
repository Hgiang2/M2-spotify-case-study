package menu.template;

import constant.Constants;
import entity.Playlist;
import menu.features.addLocalSongsToPlaylist.CommandAddLocalSongsToPlaylistProcess;
import services.AllSongListManagement;
import services.AllSongsListManagement;
import services.SongInPlaylistManagement;

public class NavigateChooseLocalSongs implements Navigator{
    private Playlist playlist;
    private Navigator navigateBack;

    public NavigateChooseLocalSongs(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    private void displayAddToPlaylists() {
        AllSongListManagement listManagement = new SongInPlaylistManagement(playlist);
        Menu menu = new MenuInputListTemplate(AllSongsListManagement.getInstance(), "Choose from your local library: ");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandAddLocalSongsToPlaylistProcess(listManagement, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayAddToPlaylists();
    }
}
