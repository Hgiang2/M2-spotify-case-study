package menu.service.mainMenuCommand.selectSearchResult;

import entity.Song;
import menu.menuCommand.Command;

public class CommandStreamSong implements Command {
    private Song song;

    public CommandStreamSong(Song song) {
        this.song = song;
    }

    @Override
    public void execute() {

    }
}
