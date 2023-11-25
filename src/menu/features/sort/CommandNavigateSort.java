package menu.features.sort;

import menu.template.Command;
import menu.template.NavigateMenuSort;
import menu.template.Navigator;
import services.Sortable;

public class CommandNavigateSort implements Command {
    private Sortable list;
    private Navigator navigateBack;

    public CommandNavigateSort(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        Navigator navigator = new NavigateMenuSort(list, navigateBack);
        navigator.navigate();
    }
}
