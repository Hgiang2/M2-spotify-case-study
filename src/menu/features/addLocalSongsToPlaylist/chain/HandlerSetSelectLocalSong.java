package menu.features.addLocalSongsToPlaylist.chain;

import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;
import services.AllSongsListManagement;

public class HandlerSetSelectLocalSong implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerSetSelectLocalSong(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        for (Integer choice : selectedItems.getChoiceList()) {
            selectedItems.getSelectedSong().add(AllSongsListManagement.getInstance().getSongs().get(choice));
        }
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
