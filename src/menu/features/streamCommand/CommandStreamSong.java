package menu.features.streamCommand;

import menu.features.Command;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandStreamSong implements Command {
    private int index;
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandStreamSong(int index, AllSongListManagement listManagement, Navigator navigateBack) {
        this.index = index;
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

//    public CommandStreamSong(int index, AllSongListManagement listManagement) {
//        this.index = index;
//        this.listManagement = listManagement;
//    }

    @Override
    public void execute() {
        CommandStreamMusicPlayer musicPlayer = new CommandStreamMusicPlayer(index, listManagement.getSongs(), navigateBack);
        musicPlayer.execute();
    }
}
