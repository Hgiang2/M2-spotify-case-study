package menu.template;

import constant.Constants;
import menu.features.Command;

public class NavigateWrongAttempts implements Navigator{
    public Command commandBack;

    public NavigateWrongAttempts(Command commandBack) {
        this.commandBack = commandBack;
    }

    private void displayWrongAttemps() {
        Menu menu = new MenuTemplate("Wrong attempts", "Do you want to try again?");
        menu.addMenuItem(new MenuItem("Try again", commandBack));
        menu.addMenuItem(new MenuItem("Back to Start", Constants.BACK_TO_START));
        menu.runMenu();
    }

    @Override
    public void navigate() {
        displayWrongAttemps();
    }
}
