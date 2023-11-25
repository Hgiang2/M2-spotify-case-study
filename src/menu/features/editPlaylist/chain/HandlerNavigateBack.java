package menu.features.editPlaylist.chain;

import entity.Playlist;
import menu.features.editPlaylist.HandleEditPlaylist;
import menu.template.NavigateSelectPlaylist;
import menu.template.Navigator;

public class HandlerNavigateBack implements HandleEditPlaylist {
    private HandleEditPlaylist next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandleEditPlaylist next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(String name, Playlist playlist) {
        System.out.println("Playlist name has been changed to " + playlist.getName());
        Navigator navigator = new NavigateSelectPlaylist(playlist, navigateBack);
        navigator.navigate();
        return true;
    }

    @Override
    public void handle(String name, Playlist playlist) {
        if (!doHandle(name, playlist)) {
            return;
        }
        if (next != null) {
            next.handle(name, playlist);
        }
    }
}
