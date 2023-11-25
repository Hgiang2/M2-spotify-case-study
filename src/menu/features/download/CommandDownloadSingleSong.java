package menu.features.download;

import entity.Song;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.download.chain.HandlerCheckExisted;
import menu.features.download.chain.HandlerNavigateBack;
import menu.template.Command;
import menu.template.Navigator;
import services.AllSongsListManagement;

public class CommandDownloadSingleSong implements Command {
    private AllSongsListManagement listManagement = null;
    private Song song;
    private Navigator navigateBack;

    public CommandDownloadSingleSong(Song song, Navigator navigateBack) {
        this.song = song;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleSong handlerBack = new HandlerNavigateBack(null, navigateBack);
        HandleChooseMultipleSong handlerCheckExisted = new HandlerCheckExisted(handlerBack);
        SelectedItems selectedItems = new SelectedItems();
        selectedItems.getSelectedSong().add(song);
        handlerCheckExisted.handle(listManagement, selectedItems);
    }
}
