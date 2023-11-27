package menu.features.selectSearchResult;

import menu.features.Command;
import menu.template.NavigateSelectGenre;
import menu.template.Navigator;

public class CommandSelectGenre implements Command {
    private String genre;
    private Navigator navigatorBack;

    public CommandSelectGenre(String genre, Navigator navigatorBack) {
        this.genre = genre;
        this.navigatorBack = navigatorBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateSelectGenre(genre, navigatorBack);
        navigator.navigate();
    }
}
