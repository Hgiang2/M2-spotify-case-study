package menu.features.addToPlaylists.addSingle;

import entity.Song;
import menu.features.Command;
import menu.template.Navigator;
import menu.features.addToPlaylists.addSingle.chain.HandlerCheckPlaylistListEmpty;
import menu.features.addToPlaylists.addSingle.chain.HandlerNavigateAllPlaylist;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

public class CommandAddSingleSongToPlaylistProcess implements Command {
    private Song song;
    private Navigator navigateBack;

    public CommandAddSingleSongToPlaylistProcess(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleItems handlerNavigateAllPlaylist = new HandlerNavigateAllPlaylist(null, navigateBack);
        HandleChooseMultipleItems handlerCheckPlaylist = new HandlerCheckPlaylistListEmpty(handlerNavigateAllPlaylist);

        SelectedItems selectedItems = new SelectedItems();
        selectedItems.getSelectedSong().add(song);
        handlerCheckPlaylist.handle(selectedItems);
    }
}
