package menu.features.addToPlaylists.selectPlaylists.chain;

import menu.template.Navigator;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class HandlerNavigateBack implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandleChooseMultipleItems next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        navigateBack.navigate();
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
