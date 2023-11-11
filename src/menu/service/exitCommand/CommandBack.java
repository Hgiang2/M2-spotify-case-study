package menu.service.exitCommand;

import menu.menuCommand.Command;
import menu.menuCommand.Navigator;

public class CommandBack implements Command {
    private Navigator menu;

    public CommandBack(Navigator menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Exiting...........");
        System.out.println();
        this.menu.navigate();
    }
}
