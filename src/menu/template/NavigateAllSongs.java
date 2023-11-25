package menu.template;

import constant.Constants;
import menu.features.addToFavorites.addMultiple.CommandAddMultipleToFavorites;
import menu.features.addToPlaylists.selectSongs.CommandAddMultipleToPlaylists;
import menu.features.deleteMultipleLocalSong.CommandDeleteMultipleSong;
import menu.features.exitCommand.CommandBack;
import menu.features.sort.CommandNavigateSort;
import menu.features.streamCommand.CommandStreamListOrderly;
import menu.features.streamCommand.CommandStreamSong;
import services.AllSongListManagement;
import services.AllSongsListManagement;
import services.Sortable;

public class NavigateAllSongs implements Navigator{
    private void displayAllSongs() {
        AllSongListManagement allSongs = AllSongsListManagement.getInstance();
        Menu menu = new MenuResultListTemplate("Your Songs", "Your Songs", allSongs.getSongs().size());
        for (int i = 0; i < allSongs.getSongs().size(); i++) menu.addMenuItem(new MenuItem(allSongs.getSongs().get(i).toString(), new CommandStreamSong(i, allSongs, this)));
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem(Constants.STREAM_LIST, new CommandStreamListOrderly(allSongs, this)));
        menu.addMenuItem(new MenuItem(Constants.SORT, new CommandNavigateSort((Sortable) allSongs, this)));
        menu.addMenuItem(new MenuItem("Add Multiple to Favorites", new CommandAddMultipleToFavorites(allSongs, this)));
        menu.addMenuItem(new MenuItem("Add Multiple to Playlists", new CommandAddMultipleToPlaylists(allSongs, this)));
        menu.addMenuItem(new MenuItem("Delete Multiple", new CommandDeleteMultipleSong()));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        if (AllSongsListManagement.getInstance().getSongs().isEmpty()) {
            System.out.println("Your library is empty!");
            Navigator navigator = new NavigateExploreNewMusic();
            navigator.navigate();
        } else {
            displayAllSongs();
        }
    }
}
