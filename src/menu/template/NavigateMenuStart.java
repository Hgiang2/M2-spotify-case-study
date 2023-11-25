package menu.template;

import constant.Constants;
import entity.Favorites;
import menu.features.exitCommand.CommandExit;
import menu.features.userCommand.logInCommand.CommandLogIn;
import menu.features.userCommand.signInCommand.CommandSignIn;
import services.AllPlaylistsListManagement;
import services.observer.Observer;
import services.observer.Subject;

public class NavigateMenuStart extends Subject implements Navigator {
    private void displayMenuStart() {
        createInstance();
        Menu menuStart = new MenuTemplate(Constants.USER_START_MENU_TITLE, Constants.USER_START_MENU_DESCRIPTION);
        menuStart.addMenuItem(new MenuItem(Constants.EXIT, new CommandExit()));
        menuStart.addMenuItem(new MenuItem("New to Spotify", new CommandSignIn()));
        menuStart.addMenuItem(new MenuItem("An existed user", new CommandLogIn()));
        menuStart.runMenu();
    }

    private void createInstance() {
        if (AllPlaylistsListManagement.getInstance().getAllPlaylists().isEmpty()) {
            Observer observeAllPlaylists = AllPlaylistsListManagement.getInstance();
            addObserver(observeAllPlaylists);
            Favorites.getInstance();
            notifyObserver();
            removeAll();
        }
    }

    @Override
    public void navigate() {
        displayMenuStart();
    }
}