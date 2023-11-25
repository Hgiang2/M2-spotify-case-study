package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandBack;
import menu.features.selectSearchResult.CommandSelectGenre;
import services.AllGenreListManagement;

import java.util.List;

public class NavigateAllGenres implements Navigator {
    private void displayAllGenres() {
        List<String> genres = AllGenreListManagement.getInstance().getList();
        Menu menu = new MenuResultListTemplate(Constants.ALL_GENRES, Constants.ALL_GENRES, genres.size());
        for (int i = 0; i < genres.size(); i++) {
            menu.addMenuItem(new MenuItem(genres.get(i), new CommandSelectGenre(genres.get(i), this)));
        }
        menu.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(new NavigateLocalLibrary())));
        menu.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        if (AllGenreListManagement.getInstance().getList().isEmpty()) {
            System.out.println();
            System.out.println("No genres yet!");
        }
        displayAllGenres();
    }
}
