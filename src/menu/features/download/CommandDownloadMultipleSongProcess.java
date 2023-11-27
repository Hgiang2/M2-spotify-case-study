package menu.features.download;

import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.addToPlaylists.selectSongs.chain.HandlerCheckChoice;
import menu.features.addToPlaylists.selectSongs.chain.HandlerSetSelectedSong;
import menu.features.addToPlaylists.selectSongs.chain.HandlerValidChoiceFormatPlaylist;
import menu.features.download.chain.HandlerCheckExisted;
import menu.features.download.chain.HandlerNavigateBack;
import menu.features.Command;
import menu.features.CommandInput;
import menu.template.Navigator;
import services.AllSongListManagement;

public class CommandDownloadMultipleSongProcess implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandDownloadMultipleSongProcess(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleSong handleBack = new HandlerNavigateBack(null, navigateBack);
        HandleChooseMultipleSong handleDownloadSongs = new HandlerCheckExisted(handleBack);
        HandleChooseMultipleSong handleSetSelectedSong = new HandlerSetSelectedSong(handleDownloadSongs);
        HandleChooseMultipleSong handleCheckChoice = new HandlerCheckChoice(handleSetSelectedSong, navigateBack);
        HandleChooseMultipleSong handlerCheckFormat = new HandlerValidChoiceFormatPlaylist(handleCheckChoice);

        CommandInput input = new CommandInputMultipleInt("Type numbers with space in between: ");
        input.execute();
        SelectedItems selectedItems = new SelectedItems(input.getInput());
        handlerCheckFormat.handle(listManagement, selectedItems);
    }
}
