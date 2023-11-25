package menu.template;

import constant.Constants;
import entity.Song;
import menu.features.exitCommand.CommandBack;
import menu.features.streamCommand.CommandStreamSingleSong;

public class NavigateSelectNormalSpotifySong implements Navigator{
    private Song song;
    private Navigator navigateBack;

    public NavigateSelectNormalSpotifySong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }
    private void displaySelectNormalSong() {
        Menu menuSpotifySong = new MenuTemplate(song.getName(), song.toString());
        menuSpotifySong.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
        menuSpotifySong.addMenuItem(new MenuItem("Stream", new CommandStreamSingleSong(song, this)));
        menuSpotifySong.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, new CommandBack(new NavigateMenuNormalMain())));
        menuSpotifySong.runMenu();
    }

    @Override
    public void navigate() {
        displaySelectNormalSong();
    }
}
