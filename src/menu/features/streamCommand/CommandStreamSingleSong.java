package menu.features.streamCommand;

import entity.Song;
import menu.features.Command;
import menu.template.Navigator;

public class CommandStreamSingleSong implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandStreamSingleSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        CommandStreamMusicPlayer musicPlayer = new CommandStreamMusicPlayer(song, navigateBack);
        musicPlayer.execute();
    }
}
