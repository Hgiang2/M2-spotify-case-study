package menu.menuCommand;

import entity.AllSongsList;
import menu.service.exitCommand.CommandBack;
import services.singleton.DisplayList;

public class NavigateDisplayAllSongs implements Navigator{
    private void displayAllSongs(){
        Menu menuDisplayAllSongs = new MenuTemplate("Your songs", "Here are all your tracks: ");
        System.out.println();
        DisplayList.getInstance().displayList(AllSongsList.getInstance().getAllSongs());
        System.out.println();
        menuDisplayAllSongs.addMenuItem(new MenuItem("Return to Main", new CommandBack(new NavigateMenuMain())));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Play/Stop", new CommandStreamSelectedSong()));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Add to Favorites", new CommandAddToFavorites()));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Add to Playlists", new CommandAddToPlaylists()));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Sort", new CommandSortSongs()));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Filter", new CommandFilterSongs()));
        menuDisplayAllSongs.addMenuItem(new MenuItem("Delete", new CommandDeleteMultipleSongs()));
    }
    @Override
    public void navigate() {
        displayAllSongs();
    }
}
