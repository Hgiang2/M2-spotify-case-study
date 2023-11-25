package menu.template;

import constant.Constants;
import menu.features.yourLibrary.allPlaylists.CommandNavigateAllPlaylists;
import menu.features.searchCommand.searchLocalLibrary.CommandSearchLocal;
import menu.features.yourLibrary.CommandAllArtists;
import menu.features.yourLibrary.CommandAllGenres;
import menu.features.yourLibrary.CommandAllSongs;

public class NavigateLocalLibrary implements Navigator {
    private void displayLocalLibrary() {
        Menu menuLocalLibrary = new MenuTemplate("Your library", "Your library");
        menuLocalLibrary.addMenuItem(new MenuItem("Return to Main", Constants.BACK_TO_MAIN));
        menuLocalLibrary.addMenuItem(new MenuItem("Search your library", new CommandSearchLocal()));
        menuLocalLibrary.addMenuItem(new MenuItem("Your songs", new CommandAllSongs()));
        menuLocalLibrary.addMenuItem(new MenuItem("Your playlists", new CommandNavigateAllPlaylists()));
        menuLocalLibrary.addMenuItem(new MenuItem("Your artists", new CommandAllArtists()));
        menuLocalLibrary.addMenuItem(new MenuItem("Your genres", new CommandAllGenres()));
        menuLocalLibrary.runMenu();
    }

    @Override
    public void navigate() {
        displayLocalLibrary();
    }
}
