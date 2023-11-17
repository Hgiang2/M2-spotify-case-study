package menu.service.streamCommand;

import menu.menuCommand.Command;
import services.AllSongListManagement;

public class CommandStreamListOrderly implements Command {
    private AllSongListManagement listManagement;

    public CommandStreamListOrderly(AllSongListManagement listManagement) {
        this.listManagement = listManagement;
    }

    @Override
    public void execute() {

    }
}
