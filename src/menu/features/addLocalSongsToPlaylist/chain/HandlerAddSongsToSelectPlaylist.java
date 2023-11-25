package menu.features.addLocalSongsToPlaylist.chain;

import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;

public class HandlerAddSongsToSelectPlaylist implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerAddSongsToSelectPlaylist(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        listManagement.addSongs(selectedItems.getSelectedSong());
        System.out.println("Songs added to " + listManagement.getTitle() + " successfully!");
        return true;
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        if (!doHandle(listManagement, selectedItems)) {
            return;
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
