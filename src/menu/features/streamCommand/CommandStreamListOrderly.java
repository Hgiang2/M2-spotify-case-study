package menu.features.streamCommand;

import menu.features.Command;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandStreamListOrderly implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandStreamListOrderly(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        CommandStreamMusicPlayer musicPlayer = new CommandStreamMusicPlayer(0, listManagement.getSongs(), navigateBack);
        musicPlayer.execute();
    }
}
