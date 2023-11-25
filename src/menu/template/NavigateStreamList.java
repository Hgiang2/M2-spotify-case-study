package menu.template;

import entity.Song;

import java.util.List;

public class NavigateStreamList implements Navigator{
    private List<Song> songList;
    private Navigator navigateBack;
    public NavigateStreamList(List<Song> songList, Navigator navigateBack) {
        this.songList = songList;
        this.navigateBack = navigateBack;
    }

    private void displayStreamList() {
//        Menu menuStream = new MenuTemplate(Constants.STREAM, Constants.BLANK);
//        DisplaySongList displaySongList = new DisplaySongList(menuStream, songList, this);
//        displaySongList.display();
//        System.out.println();
//        menuStream.addMenuItem(new MenuItem(Constants.BACK, new CommandBack(navigateBack)));
//        menuStream.addMenuItem(new MenuItem("Play in Order", new CommandPlayInOrder(songList)));
//        menuStream.addMenuItem(new MenuItem("Play Randomly", new CommandPlayRandomly(songList)));
//        menuStream.addMenuItem(new MenuItem(Constants.RETURN_TO_MAIN, Constants.BACK_TO_MAIN));

    }
    @Override
    public void navigate() {
        displayStreamList();
    }
}
