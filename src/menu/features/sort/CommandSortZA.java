package menu.features.sort;

import menu.template.Command;
import menu.template.Navigator;
import services.Sortable;

public class CommandSortZA implements Command {
    private Sortable list;
    private Navigator navigateBack;

    public CommandSortZA(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        list.sortZA();
        navigateBack.navigate();
    }
}
