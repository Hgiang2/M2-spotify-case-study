package menu.features.addToPlaylists.selectPlaylists;

import menu.features.addToPlaylists.selectSongs.SelectedItems;

public interface HandleChooseMultipleItems {
    boolean doHandle(SelectedItems selectedItems);
    void handle(SelectedItems selectedItems);
}
