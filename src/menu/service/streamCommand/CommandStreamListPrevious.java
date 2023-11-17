package menu.service.streamCommand;

import menu.menuCommand.Command;
import services.AllSongListManagement;

public class CommandStreamListPrevious implements Command {
    private AllSongListManagement listManagement;

    public CommandStreamListPrevious(AllSongListManagement listManagement) {
        this.listManagement = listManagement;
    }

    @Override
    public void execute() {

    }
}
