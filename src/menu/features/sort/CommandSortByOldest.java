package menu.features.sort;

import menu.features.Command;
import menu.template.Navigator;
import services.Sortable;

public class CommandSortByOldest implements Command {
    private Sortable list;
    private Navigator navigateBack;

    public CommandSortByOldest(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        list.sortByOldest();
        navigateBack.navigate();
    }
}
