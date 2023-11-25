package menu.template;

import constant.Constants;
import entity.Playlist;
import menu.features.addLocalSongsToPlaylist.CommandAddLocalSongsToPlaylist;
import menu.features.addToFavorites.addMultiple.CommandAddMultipleToFavorites;
import menu.features.deletePlaylist.CommandDeletePlaylist;
import menu.features.editPlaylist.CommandEditPlaylist;
import menu.features.exitCommand.CommandBack;
import menu.features.removeMultiple.CommandRemoveMultipleFromPlaylist;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.SongInPlaylistManagement;

public class NavigateSelectPlaylist implements Navigator{
    private Playlist playlist;
    private Navigator navigateBack;

    public NavigateSelectPlaylist(Playlist playlist, Navigator navigatorBack) {
        this.playlist = playlist;
        this.navigateBack = navigatorBack;
    }

    private void displayPlaylist() {
        AllSongListManagement playlistSongs = new SongInPlaylistManagement(playlist);
        Menu menuPlaylist = new MenuResultListTemplate(playlist.getName(), playlist.getName(), playlistSongs.getSongs().size());
        for (int i = 0; i < playlistSongs.getSongs().size(); i++) {
            menuPlaylist.addMenuItem(new MenuItem(playlistSongs.getSongs().get(i).toString(), new CommandStreamSong(i, playlistSongs, this)));
        }
        menuPlaylist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menuPlaylist.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(playlistSongs, this)));
        menuPlaylist.addMenuItem(new MenuItem("Edit this playlist", new CommandEditPlaylist(playlist, navigateBack)));
        menuPlaylist.addMenuItem(new MenuItem("Add Multiple to Favorites", new CommandAddMultipleToFavorites(playlistSongs, this)));
        menuPlaylist.addMenuItem(new MenuItem("Add Songs", new CommandAddLocalSongsToPlaylist(playlist, this)));
        menuPlaylist.addMenuItem(new MenuItem("Remove Multiple from Playlist", new CommandRemoveMultipleFromPlaylist(playlistSongs, this)));
        menuPlaylist.addMenuItem(new MenuItem("Delete this playlist", new CommandDeletePlaylist(playlist, navigateBack)));
        menuPlaylist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menuPlaylist.runMenu();
    }

    private void displayAddSongs() {
        Menu menu = new MenuInputTemplate("Add Songs", playlist.getName() + " is empty! Let's add some songs to this playlist.");
        menu.addMenuItem(new MenuItem(Constants.BLANK, new CommandAddLocalSongsToPlaylist(playlist, new NavigateSelectPlaylist(playlist, new NavigateAllPlaylists()))));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        if (!playlist.getSongsInPlaylist().isEmpty()) {
            displayPlaylist();
        } else {
            displayAddSongs();
        }
    }
}
