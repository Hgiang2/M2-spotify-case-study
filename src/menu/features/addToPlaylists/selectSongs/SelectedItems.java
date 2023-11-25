package menu.features.addToPlaylists.selectSongs;

import entity.Playlist;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SelectedItems {
    private String choice;
    private List<Integer> choiceList = new ArrayList<>();
    private List<Song> selectedSong = new ArrayList<>();
    private List<Playlist> selectedPlaylist = new ArrayList<>();

    public SelectedItems() {
    }

    public SelectedItems(String choice) {
        this.choice = choice;
    }

    public List<Song> getSelectedSong() {
        return selectedSong;
    }

    public void setSelectedSong(List<Song> selectedSong) {
        this.selectedSong = selectedSong;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<Integer> getChoiceList() {
        return choiceList;
    }

    public List<Playlist> getSelectedPlaylist() {
        return selectedPlaylist;
    }

    public void setSelectedPlaylist(List<Playlist> selectedPlaylist) {
        this.selectedPlaylist = selectedPlaylist;
    }

    public void setChoiceList(List<Integer> choiceList) {
        this.choiceList = choiceList;
    }
}
