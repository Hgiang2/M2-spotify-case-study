package menu.features.createPlaylist.chain;

import entity.Playlist;
import menu.features.Command;
import menu.template.Navigator;
import menu.features.createPlaylist.HandlePlaylist;
import menu.features.exitCommand.CommandBack;

public class HandlerNavigateBack implements HandlePlaylist {
    private HandlePlaylist next;
    private Navigator navigateBack;

    public HandlerNavigateBack(HandlePlaylist next, Navigator navigateBack) {
        this.next = next;
        this.navigateBack = navigateBack;
    }

    @Override
    public boolean doHandle(Playlist playlist) {
        Command back = new CommandBack(navigateBack);
        back.execute();
        return true;
    }

    @Override
    public void handle(Playlist playlist) {
        if (!doHandle(playlist)) {
            return;
        }
        if (next != null) {
            next.handle(playlist);
        }
    }
}
