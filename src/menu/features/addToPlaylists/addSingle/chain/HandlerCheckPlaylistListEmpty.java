package menu.features.addToPlaylists.addSingle.chain;

import menu.template.Navigator;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllPlaylistsListManagement;

public class HandlerCheckPlaylistListEmpty implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;
    private Navigator navigateBack;

    public HandlerCheckPlaylistListEmpty(HandleChooseMultipleItems next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    public HandlerCheckPlaylistListEmpty(HandleChooseMultipleItems next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        return AllPlaylistsListManagement.getInstance().getAllPlaylists().size() > 1;
    }

    @Override
    public void handle(SelectedItems selectedItems) {
        if (!doHandle(selectedItems)) {
            HandleChooseMultipleItems handlerNavigateNoPlaylist = new HandlerNavigateNoPlaylist(null, navigateBack);
            handlerNavigateNoPlaylist.handle(selectedItems);
        }
        if (next != null) {
            next.handle(selectedItems);
        }
    }
}
