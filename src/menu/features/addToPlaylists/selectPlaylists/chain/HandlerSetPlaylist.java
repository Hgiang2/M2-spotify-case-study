package menu.features.addToPlaylists.selectPlaylists.chain;

import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllPlaylistsListManagement;

public class HandlerSetPlaylist implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;

    public HandlerSetPlaylist(HandleChooseMultipleItems next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        for (Integer choice : selectedItems.getChoiceList()) {
            selectedItems.getSelectedPlaylist().add(AllPlaylistsListManagement.getInstance().getAllPlaylists().get(choice));
        }
        return true;
    }

    @Override
    public void handle(SelectedItems selectedItems) {
        if (!doHandle(selectedItems)) {
            return;
        }
        if (next != null) {
            next.handle(selectedItems);
        }
    }
}
