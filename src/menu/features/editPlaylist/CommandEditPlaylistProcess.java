package menu.features.editPlaylist;

import entity.Playlist;
import menu.features.Command;
import menu.features.CommandInput;
import menu.template.NavigateSelectPlaylist;
import menu.template.Navigator;
import menu.features.createPlaylist.CommandInputPlaylistName;
import menu.features.editPlaylist.chain.HandlerNavigateBack;
import menu.features.editPlaylist.chain.HandlerSetNewPlaylistName;

public class CommandEditPlaylistProcess implements Command {
    private Playlist playlist;
    private Navigator navigateBack;

    public CommandEditPlaylistProcess(Playlist playlist, Navigator navigateBack) {
        this.playlist = playlist;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleEditPlaylist handlerNavigateBack = new HandlerNavigateBack(null, new NavigateSelectPlaylist(playlist, navigateBack));
        HandleEditPlaylist handlerSetNewName = new HandlerSetNewPlaylistName(handlerNavigateBack);

        CommandInput input = new CommandInputPlaylistName("Enter a new name for your playlist: ");
        input.execute();
        String name = input.getInput();
        handlerSetNewName.handle(name, playlist);
    }
}
