package menu.features.removeMultiple.chain;

import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;

public class HandlerNavigateBack implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandleChooseMultipleSong next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        navigateBack.navigate();
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
