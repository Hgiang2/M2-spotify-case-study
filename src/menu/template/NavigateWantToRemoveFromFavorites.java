package menu.template;

import entity.Song;
import menu.features.removeMultiple.CommandRemoveFromFavorites;
import menu.features.exitCommand.CommandBack;

public class NavigateWantToRemoveFromFavorites implements Navigator{
    private Song song;
    private Navigator navigateBack;

    public NavigateWantToRemoveFromFavorites(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    private void displayWantToRemoveFromFavorites() {
        Menu menu = new MenuTabTemplate("Remove from Favorites", "Do you want to remove " + song.getName() + " - " + song.getArtist() + " from Favorites?");
        menu.addMenuItem(new MenuItem("Yes", new CommandRemoveFromFavorites(song, navigateBack)));
        menu.addMenuItem(new MenuItem("No", new CommandBack(navigateBack)));
        menu.runMenu();
    }
    @Override
    public void navigate() {
        displayWantToRemoveFromFavorites();
    }
}
