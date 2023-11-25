package menu.features.deleteMultipleLocalSong.chain;

import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.template.NavigateConfirmDeleteMultiple;
import menu.template.Navigator;
import services.AllSongListManagement;

public class HandlerConfirmDelete implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerConfirmDelete(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        Navigator navigator = new NavigateConfirmDeleteMultiple(selectedItems);
        navigator.navigate();
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
