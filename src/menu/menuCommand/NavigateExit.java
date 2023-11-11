package menu.menuCommand;

import constant.Constants;
import menu.service.exitCommand.CommandEndProgram;
import menu.service.exitCommand.CommandOpenNextTime;
import menu.service.exitCommand.CommandReOpen;

public class NavigateExit implements Navigator {
    private void displayExitScreen() {
        Menu menuExit = new MenuTemplate(Constants.EXIT, Constants.EXIT_DESCRIPTION);
        menuExit.addMenuItem(new MenuItem("End here", new CommandEndProgram()));
        menuExit.addMenuItem(new MenuItem("Sure!", new CommandReOpen()));
        menuExit.addMenuItem(new MenuItem("Maybe next time!", new CommandOpenNextTime()));
        menuExit.runMenu();
    }

    @Override
    public void navigate() {
        displayExitScreen();
    }
}
