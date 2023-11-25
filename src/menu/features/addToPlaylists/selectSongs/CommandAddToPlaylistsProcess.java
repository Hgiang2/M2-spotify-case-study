package menu.features.addToPlaylists.selectSongs;

import menu.template.Command;
import menu.template.CommandInput;
import menu.template.Navigator;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.chain.HandlerCheckChoice;
import menu.features.addToPlaylists.selectSongs.chain.HandlerCheckPlaylist;
import menu.features.addToPlaylists.selectSongs.chain.HandlerNavigateSelectOrCreatePlaylist;
import menu.features.addToPlaylists.selectSongs.chain.HandlerSetSelectedSong;
import menu.features.addToPlaylists.selectSongs.chain.HandlerValidChoiceFormatPlaylist;
import services.AllSongListManagement;

public class CommandAddToPlaylistsProcess implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandAddToPlaylistsProcess(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleSong handlerNavigateAllPlaylist = new HandlerNavigateSelectOrCreatePlaylist(null, navigateBack);
        HandleChooseMultipleSong handlerCheckPlaylist = new HandlerCheckPlaylist(handlerNavigateAllPlaylist, navigateBack);
        HandleChooseMultipleSong handlerSetSelectedSong = new HandlerSetSelectedSong(handlerCheckPlaylist);
        HandleChooseMultipleSong handlerCheckChoice = new HandlerCheckChoice(handlerSetSelectedSong, navigateBack);
        HandleChooseMultipleSong handleValidFormat = new HandlerValidChoiceFormatPlaylist(handlerCheckChoice);

        CommandInput inputChoice = new CommandInputMultipleInt("Type numbers with space in between: ");
        inputChoice.execute();
        SelectedItems selectedItems = new SelectedItems(inputChoice.getInput());

        handleValidFormat.handle(listManagement, selectedItems);
    }
}
