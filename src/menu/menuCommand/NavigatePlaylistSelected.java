package menu.menuCommand;

import entity.Playlist;

public class NavigatePlaylistSelected implements Navigator{
    private Playlist playlist;
    private Navigator navigatorBack;

    public NavigatePlaylistSelected(Playlist playlist, Navigator navigatorBack) {
        this.playlist = playlist;
        this.navigatorBack = navigatorBack;
    }

    private void DisplayPlaylist() {
//        Menu menuPlaylist = new MenuTemplate(playlist.getName(), playlist.getName());
//        DisplaySongList displaySongList = new DisplaySongList(menuPlaylist, new SongInPlaylistManagement(playlist).getSongsInPlaylist(), this);
//
//        System.out.println();
//        displaySongList.display();
//        System.out.println();
//        menuPlaylist.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigatorBack)));
//        menuPlaylist.addMenuItem(new MenuItem(Constants.STREAM, new CommandStream(new SongInPlaylistManagement(playlist).getSongsInPlaylist(), this)));
//        menuPlaylist.addMenuItem(new MenuItem("Add Multiple to Favorites", new CommandAddToFavorites(playlist.getSongsInPlaylist())));
//        menuPlaylist.addMenuItem(new MenuItem("Add Multiple to Playlists", new CommandAddToPlaylists(playlist.getSongsInPlaylist())));
//        menuPlaylist.addMenuItem(new MenuItem("Delete Multiple", new CommandDeleteMultiple(playlist.getSongsInPlaylist())));
//        menuPlaylist.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
    }
    @Override
    public void navigate() {
        DisplayPlaylist();
    }
}
