package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;
import menu.features.searchCommand.searchLocalLibrary.CommandSearchLocalProcess;
import menu.features.searchCommand.searchNewMusic.CommandExploreNewMusic;
import services.AllSongsListManagement;

public class NavigateSearchLocalLibrary implements Navigator {
    private void displaySearchLocal() {
        Menu menuExploreNewMusic = new MenuInputTemplate("Search your library", "Find the thing you need in the local library!");
        menuExploreNewMusic.addMenuItem(new MenuItem(Constants.BLANK, new CommandSearchLocalProcess()));
        menuExploreNewMusic.runMenu();
    }

    private void displayEmptyLibrary() {
        Menu menu = new MenuTemplate("Empty library", "Your local library is Empty!");
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem("Explore new songs", new CommandExploreNewMusic()));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        if (AllSongsListManagement.getInstance().getSongs().isEmpty()) {
            displayEmptyLibrary();
        } else {
            displaySearchLocal();
        }
    }
}
