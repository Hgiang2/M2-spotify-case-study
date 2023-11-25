package menu.template;

import constant.Constants;
import entity.Favorites;
import entity.Song;
import menu.features.addLocalSongsToPlaylist.CommandAddLocalSongsToPlaylist;
import menu.features.exitCommand.CommandBack;
import menu.features.removeMultiple.CommandRemoveMultipleFromPlaylist;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.SongInPlaylistManagement;

import java.util.List;

public class NavigateSelectFavoritesMenu implements Navigator{
    private void displayFavoritesMenu() {
        AllSongListManagement favoritesManagement = new SongInPlaylistManagement(Favorites.getInstance());
        List<Song> favorites = Favorites.getInstance().getSongsInPlaylist();
        Menu menu = new MenuResultListTemplate(Favorites.getInstance().getName(), Favorites.getInstance().getName(), favorites.size());
        for (int i = 0; i < favorites.size(); i++) {
            menu.addMenuItem(new MenuItem(favorites.get(i).toString(), new CommandStreamSong(i, favoritesManagement, this)));
        }
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateAllPlaylists())));
        menu.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(favoritesManagement, this)));
        menu.addMenuItem(new MenuItem("Add Songs", new CommandAddLocalSongsToPlaylist(Favorites.getInstance(), this)));
        menu.addMenuItem(new MenuItem("Remove Multiple from Favorites", new CommandRemoveMultipleFromPlaylist(favoritesManagement, this)));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayFavoritesMenu();
    }
}
