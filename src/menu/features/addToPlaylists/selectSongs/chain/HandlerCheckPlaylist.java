package menu.features.addToPlaylists.selectSongs.chain;

import menu.template.NavigateNoPlaylist;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllPlaylistsListManagement;
import services.AllSongListManagement;

public class HandlerCheckPlaylist implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;
    private Navigator navigateBack;

    public HandlerCheckPlaylist(HandleChooseMultipleSong next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        return AllPlaylistsListManagement.getInstance().getAllPlaylists().size() > 1;
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        if (!doHandle(listManagement, selectedItems)) {
            Navigator navigate = new NavigateNoPlaylist(selectedItems, navigateBack);
            navigate.navigate();
            return;
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
