package menu.features.favoritesSelect;

import menu.features.Command;
import menu.template.NavigateSelectFavoritesMenu;
import menu.template.Navigator;

public class CommandSelectFavorites implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectFavoritesMenu();
        navigator.navigate();
    }
}
