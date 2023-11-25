package menu.template;

import constant.Constants;
import menu.features.exitCommand.CommandEndProgram;
import menu.features.exitCommand.CommandOpenGmail;
import menu.features.exitCommand.CommandReOpen;

public class NavigateExit implements Navigator {
    private void displayExitScreen() {
        System.out.println();
        System.out.println("Exiting...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
        Menu menuExit = new MenuTemplate(Constants.EXIT, Constants.EXIT_DESCRIPTION);
        menuExit.addMenuItem(new MenuItem("End program", new CommandEndProgram()));
        menuExit.addMenuItem(new MenuItem("Spotify", new CommandReOpen()));
        menuExit.addMenuItem(new MenuItem("Gmail", new CommandOpenGmail()));
        menuExit.runMenu();
    }

    @Override
    public void navigate() {
        displayExitScreen();
    }
}
