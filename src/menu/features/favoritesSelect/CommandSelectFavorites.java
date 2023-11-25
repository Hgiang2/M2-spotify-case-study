package menu.features.favoritesSelect;

import menu.template.Command;
import menu.template.NavigateSelectFavoritesMenu;
import menu.template.Navigator;

public class CommandSelectFavorites implements Command {
    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectFavoritesMenu();
        navigator.navigate();
    }
}
