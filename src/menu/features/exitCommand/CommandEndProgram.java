package menu.features.exitCommand;

import menu.features.Command;

public class CommandEndProgram implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
