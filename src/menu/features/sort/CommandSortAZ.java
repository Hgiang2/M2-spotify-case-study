package menu.features.sort;

import menu.template.Command;
import menu.template.Navigator;
import services.Sortable;

public class CommandSortAZ implements Command {
    private Sortable list;
    private Navigator navigateBack;

    public CommandSortAZ(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        list.sortAZ();
        navigateBack.navigate();
    }
}
