package menu.features.addToPlaylists.addSingle.chain;

import menu.template.NavigateDisplayAllPlaylistsToChoose;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class HandlerNavigateAllPlaylist implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;
    private Navigator navigateBack;

    public HandlerNavigateAllPlaylist(HandleChooseMultipleItems next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        Navigator navigator = new NavigateDisplayAllPlaylistsToChoose(selectedItems, navigateBack);
        navigator.navigate();
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
