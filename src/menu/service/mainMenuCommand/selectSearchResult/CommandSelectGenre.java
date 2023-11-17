package menu.service.mainMenuCommand.selectSearchResult;

import menu.menuCommand.Command;
import menu.menuCommand.NavigateGenreSelected;
import menu.menuCommand.Navigator;

public class CommandSelectGenre implements Command {
    private String genre;
    private Navigator navigatorBack;

    public CommandSelectGenre(String genre, Navigator navigatorBack) {
        this.genre = genre;
        this.navigatorBack = navigatorBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateGenreSelected(genre, navigatorBack);
        navigator.navigate();
    }
}
