package menu.features.exitCommand;

import menu.template.Command;
import menu.template.Navigator;

public class CommandBack implements Command {
    private Navigator menu;

    public CommandBack(Navigator menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Return...........");
        this.menu.navigate();
    }
}
