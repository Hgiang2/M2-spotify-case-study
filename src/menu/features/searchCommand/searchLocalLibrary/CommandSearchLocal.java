package menu.features.searchCommand.searchLocalLibrary;

import menu.features.Command;
import menu.template.NavigateSearchLocalLibrary;
import menu.template.Navigator;

public class CommandSearchLocal implements Command {
    @Override
    public void execute() {
        Navigator navigate = new NavigateSearchLocalLibrary();
        navigate.navigate();
    }
}
