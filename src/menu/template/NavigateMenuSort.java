package menu.template;

import constant.Constants;
import menu.features.sort.CommandSortAZ;
import menu.features.sort.CommandSortByNewest;
import menu.features.sort.CommandSortByOldest;
import menu.features.sort.CommandSortZA;
import services.Sortable;

public class NavigateMenuSort implements Navigator{
    private Sortable list;
    private Navigator navigateBack;

    public NavigateMenuSort(Sortable list, Navigator navigateBack) {
        this.list = list;
        this.navigateBack = navigateBack;
    }

    private void displaySortMenu() {
        Menu menu = new MenuTabTemplate(Constants.SORT, Constants.BLANK);
        menu.addMenuItem(new MenuItem("SortAZ", new CommandSortAZ(list, navigateBack)));
        menu.addMenuItem(new MenuItem("SortZA", new CommandSortZA(list, navigateBack)));
        menu.addMenuItem(new MenuItem("Sort by Oldest", new CommandSortByOldest(list, navigateBack)));
        menu.addMenuItem(new MenuItem("Sort by Newest", new CommandSortByNewest(list, navigateBack)));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displaySortMenu();
    }
}
