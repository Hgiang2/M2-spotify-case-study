package menu.service.addToFavoritesCommand;

import constant.Constants;
import menu.menuCommand.CommandInput;

public class CommandInputMultipleInt implements CommandInput {
    private String choice;

    @Override
    public void execute() {
        choice = Constants.SCANNER.next();
    }

    @Override
    public String getInput() {
        return choice;
    }
}
