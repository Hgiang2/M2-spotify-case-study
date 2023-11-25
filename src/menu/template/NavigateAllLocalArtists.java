package menu.template;

import constant.Constants;
import entity.Artist;
import menu.features.exitCommand.CommandBack;
import menu.features.selectSearchResult.CommandSelectArtist;
import services.AllArtistsListManagement;

import java.util.List;

public class NavigateAllLocalArtists implements Navigator {
    private void displayAllLocalArtist() {
        List<Artist> artist = AllArtistsListManagement.getInstance().getList();
        Menu menu = new MenuResultListTemplate(Constants.ALL_ARTISTS, Constants.ALL_ARTISTS, artist.size());
        for (int i = 0; i < artist.size(); i++) {
            menu.addMenuItem(new MenuItem(artist.get(i).getUsername(), new CommandSelectArtist(artist.get(i), this)));
        }
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        if (AllArtistsListManagement.getInstance().getList().isEmpty()) {
            System.out.println();
            System.out.println("No artists yet!");
        }
        displayAllLocalArtist();
    }
}
