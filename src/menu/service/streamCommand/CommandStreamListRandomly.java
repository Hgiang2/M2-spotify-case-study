package menu.service.streamCommand;

import menu.menuCommand.Command;
import services.AllSongListManagement;

public class CommandStreamListRandomly implements Command {
    private AllSongListManagement listManagement;

    public CommandStreamListRandomly(AllSongListManagement listManagement) {
        this.listManagement = listManagement;
    }

    @Override
    public void execute() {

    }
}
