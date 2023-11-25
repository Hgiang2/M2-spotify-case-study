package menu.features.removeMultiple;

import menu.template.Command;
import menu.template.CommandInput;
import menu.template.Navigator;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.addToPlaylists.selectSongs.chain.HandlerCheckChoice;
import menu.features.addToPlaylists.selectSongs.chain.HandlerSetSelectedSong;
import menu.features.addToPlaylists.selectSongs.chain.HandlerValidChoiceFormatPlaylist;
import menu.features.removeMultiple.chain.HandlerNavigateBack;
import menu.features.removeMultiple.chain.HandlerRemoveMultipleFromPlaylist;
import services.AllSongListManagement;

public class CommandRemoveMultipleFromPlaylistProcess implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandRemoveMultipleFromPlaylistProcess(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {

        HandleChooseMultipleSong handlerBack = new HandlerNavigateBack(null, navigateBack);
        HandleChooseMultipleSong handlerRemoveMultiple = new HandlerRemoveMultipleFromPlaylist(handlerBack);
        HandleChooseMultipleSong handlerSetSelectedSong = new HandlerSetSelectedSong(handlerRemoveMultiple);
        HandleChooseMultipleSong handlerCheckChoice = new HandlerCheckChoice(handlerSetSelectedSong, navigateBack);
        HandleChooseMultipleSong handleValidFormat = new HandlerValidChoiceFormatPlaylist(handlerCheckChoice);

        CommandInput inputChoice = new CommandInputMultipleInt("Type numbers with space in between: ");
        inputChoice.execute();
        SelectedItems selectedItems = new SelectedItems(inputChoice.getInput());

        handleValidFormat.handle(listManagement, selectedItems);
    }
}
