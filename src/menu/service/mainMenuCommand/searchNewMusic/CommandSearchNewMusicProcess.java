package menu.service.mainMenuCommand.searchNewMusic;

import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;

public class CommandSearchNewMusicProcess implements Command {
    @Override
    public void execute() {

        CommandInput inputSearchItem = new CommandInputSearchItem("Search for a title or an artist: ");
        inputSearchItem.execute();
        String searchItem = inputSearchItem.getInput();


    }
}

