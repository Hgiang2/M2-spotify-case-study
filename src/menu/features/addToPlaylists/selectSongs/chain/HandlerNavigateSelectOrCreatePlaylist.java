package menu.features.addToPlaylists.selectSongs.chain;

import menu.template.NavigateSelectOrCreatePlaylistToAddSong;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;

public class HandlerNavigateSelectOrCreatePlaylist implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;
    private Navigator navigateBack;

    public HandlerNavigateSelectOrCreatePlaylist(HandleChooseMultipleSong next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    public HandlerNavigateSelectOrCreatePlaylist(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        Navigator navigator = new NavigateSelectOrCreatePlaylistToAddSong(selectedItems, navigateBack);
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
