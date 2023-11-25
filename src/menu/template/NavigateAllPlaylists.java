package menu.template;

import constant.Constants;
import entity.Playlist;
import menu.features.createPlaylist.CommandCreatePlaylist;
import menu.features.exitCommand.CommandBack;
import menu.features.favoritesSelect.CommandSelectFavorites;
import menu.features.selectSearchResult.CommandSelectPlaylist;
import menu.features.sort.CommandNavigateSort;
import services.AllPlaylistsListManagement;
import services.Sortable;

import java.util.List;

public class NavigateAllPlaylists implements Navigator {
    private void displayAllPlaylistsMenu() {
        List<Playlist> playlists = AllPlaylistsListManagement.getInstance().getAllPlaylists();
        Menu menu = new MenuResultListTemplate(Constants.ALL_PLAYLISTS, Constants.ALL_PLAYLISTS, playlists.size());
        for (int i = 0; i < playlists.size(); i++) {
            if (i == 0) {
                menu.addMenuItem(new MenuItem(playlists.get(i).getName(), new CommandSelectFavorites()));
            } else {
                menu.addMenuItem(new MenuItem(playlists.get(i).getName(), new CommandSelectPlaylist(playlists.get(i), this)));
            }
        }
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem("Create new playlist", new CommandCreatePlaylist(this)));
        menu.addMenuItem(new MenuItem(Constants.SORT, new CommandNavigateSort((Sortable) playlists, this)));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayAllPlaylistsMenu();
    }
}
