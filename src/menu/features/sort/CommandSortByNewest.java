package menu.features.sort;

import menu.features.Command;
import menu.template.Navigator;
import services.Sortable;

public class CommandSortByNewest implements Command {
    private Sortable list;
    private Navigator navigateBack;

    public CommandSortByNewest(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        list.sortByNewest();
        navigateBack.navigate();
    }
}
