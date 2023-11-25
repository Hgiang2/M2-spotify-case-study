package menu.features.streamCommand;

import entity.Song;
import menu.template.Command;
import menu.template.Navigator;
import menu.features.musicPlayer.MusicPlayer;

import java.util.ArrayList;
import java.util.List;

public class CommandStreamMusicPlayer implements Command {
    private int index;
    private List<Song> songList = new ArrayList<>();
    private Navigator navigateBack;
    private Song song;

    public CommandStreamMusicPlayer(Song song, Navigator navigateBack) {
        this.song = song;
        this.songList.add(song);
        this.navigateBack = navigateBack;
    }

    public CommandStreamMusicPlayer(int index, List<Song> songList, Navigator navigateBack) {
        this.index = index;
        this.songList = songList;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        if (song == null) {
            MusicPlayer musicPlayer = MusicPlayer.getInstance();
            if (!musicPlayer.getSongList().isEmpty()) musicPlayer.stopMusic();
            musicPlayer.setSongList(songList);
            musicPlayer.setCurrent(index);
            musicPlayer.playMusic();
            navigateBack.navigate();
        } else {
            MusicPlayer musicPlayer = MusicPlayer.getInstance();
            if (!musicPlayer.getSongList().isEmpty()) musicPlayer.stopMusic();
            musicPlayer.setSongList(songList);
            musicPlayer.setCurrent(0);
            musicPlayer.playMusic();
            navigateBack.navigate();
        }
    }
}
