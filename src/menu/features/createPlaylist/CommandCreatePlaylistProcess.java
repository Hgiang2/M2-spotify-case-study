package menu.features.createPlaylist;

import entity.Playlist;
import menu.template.Command;
import menu.template.CommandInput;
import menu.template.NavigateAllPlaylists;
import menu.template.Navigator;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.createPlaylist.chain.HandlerAddSelectedSongToPlaylist;
import menu.features.createPlaylist.chain.HandlerCheckPlaylistNameExisted;
import menu.features.createPlaylist.chain.HandlerCreateNewPlaylist;
import menu.features.createPlaylist.chain.HandlerNavigateBack;

public class CommandCreatePlaylistProcess implements Command {
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public CommandCreatePlaylistProcess(Navigator navigateBack) {
        this.navigateBack = navigateBack;
    }

    public CommandCreatePlaylistProcess(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        if (selectedItems == null) {
            HandlePlaylist handlerNavigate = new HandlerNavigateBack(null, new NavigateAllPlaylists());
            HandlePlaylist handlerCreateNewPlaylist = new HandlerCreateNewPlaylist(handlerNavigate);
            HandlePlaylist handlerCheckExisted = new HandlerCheckPlaylistNameExisted(handlerCreateNewPlaylist);
            CommandInput inputPlaylistName = new CommandInputPlaylistName("Enter new playlist's name: ");
            inputPlaylistName.execute();

            Playlist newPlaylist = new Playlist();
            newPlaylist.setName(inputPlaylistName.getInput());
            handlerCheckExisted.handle(newPlaylist);
        } else {
            HandlePlaylist handlerNavigateBack = new HandlerNavigateBack(null, navigateBack);
            HandlePlaylist handlerAddToPlaylist = new HandlerAddSelectedSongToPlaylist(handlerNavigateBack, selectedItems);
            HandlePlaylist handlerCreateNewPlaylist = new HandlerCreateNewPlaylist(handlerAddToPlaylist);
            HandlePlaylist handlerCheckExisted = new HandlerCheckPlaylistNameExisted(handlerCreateNewPlaylist);
            CommandInput inputPlaylistName = new CommandInputPlaylistName("Enter new playlist's name: ");
            inputPlaylistName.execute();

            Playlist newPlaylist = new Playlist();
            newPlaylist.setName(inputPlaylistName.getInput());
            handlerCheckExisted.handle(newPlaylist);
        }
    }
}
