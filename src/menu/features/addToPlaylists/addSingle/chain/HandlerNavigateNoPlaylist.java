package menu.features.addToPlaylists.addSingle.chain;

import menu.template.NavigateNoPlaylist;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class HandlerNavigateNoPlaylist implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;
    private Navigator navigateBack;

    public HandlerNavigateNoPlaylist(HandleChooseMultipleItems next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        Navigator navigator = new NavigateNoPlaylist(selectedItems, navigateBack);
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
