package menu.features.deleteMultipleLocalSong;

import menu.features.addLocalSongsToPlaylist.chain.HandlerSetSelectLocalSong;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.addToPlaylists.selectSongs.chain.HandlerValidChoiceFormatPlaylist;
import menu.features.deleteMultipleLocalSong.chain.HandlerCheckChoice;
import menu.features.deleteMultipleLocalSong.chain.HandlerConfirmDelete;
import menu.features.Command;
import menu.features.CommandInput;
import services.AllSongListManagement;
import services.AllSongsListManagement;

public class CommandDeleteMultipleSongProcess implements Command {
    @Override
    public void execute() {
        AllSongListManagement allSongListManagement = AllSongsListManagement.getInstance();
        HandleChooseMultipleSong handleConfirmDelete = new HandlerConfirmDelete(null);
        HandleChooseMultipleSong handleSetSelectedSong = new HandlerSetSelectLocalSong(handleConfirmDelete);
        HandleChooseMultipleSong handleCheckSize = new HandlerCheckChoice(handleSetSelectedSong);
        HandleChooseMultipleSong handleCheckFormat = new HandlerValidChoiceFormatPlaylist(handleCheckSize);


        CommandInput input = new CommandInputMultipleInt("Type numbers with space in between: ");
        input.execute();
        SelectedItems selectedItems = new SelectedItems(input.getInput());
        handleCheckFormat.handle(allSongListManagement, selectedItems);
    }
}
