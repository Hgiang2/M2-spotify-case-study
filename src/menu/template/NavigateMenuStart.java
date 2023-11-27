package menu.template;

import constant.Constants;
import entity.Admin;
import entity.EmailList;
import entity.Favorites;
import entity.RequestList;
import entity.ValidUsersList;
import menu.features.exitCommand.CommandExit;
import menu.features.registerArtist.CommandArtistRegister;
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
        menuStart.addMenuItem(new MenuItem("Register as artist", new CommandArtistRegister()));
        menuStart.runMenu();
    }

    private void createInstance() {
        RequestList.getInstance();
        EmailList.getInstance();
        if (AllPlaylistsListManagement.getInstance().getAllPlaylists().isEmpty()) {
            Observer observeAllPlaylists = AllPlaylistsListManagement.getInstance();
            addObserver(observeAllPlaylists);
            Favorites.getInstance();
            notifyObserver();
            removeAll();
        }
        if (ValidUsersList.getInstance().getValidUsers().isEmpty()) {
            Observer observeValidUsers = ValidUsersList.getInstance();
            addObserver(observeValidUsers);
            Admin.getInstance();
            notifyObserver();
            removeAll();
        }
    }

    @Override
    public void navigate() {
        displayMenuStart();
    }
}
