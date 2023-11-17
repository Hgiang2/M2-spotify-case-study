package menu.service.streamCommand;

import menu.menuCommand.Command;
import services.AllSongListManagement;

public class CommandStreamListNext implements Command {
    private AllSongListManagement listManagement;

    public CommandStreamListNext(AllSongListManagement listManagement) {
        this.listManagement = listManagement;
    }

    @Override
    public void execute() {

    }
}
