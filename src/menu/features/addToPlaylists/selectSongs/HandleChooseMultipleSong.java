package menu.features.addToPlaylists.selectSongs;

import services.AllSongListManagement;

public interface HandleChooseMultipleSong {
    boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems);
    void handle(AllSongListManagement listManagement, SelectedItems selectedItems);
}
