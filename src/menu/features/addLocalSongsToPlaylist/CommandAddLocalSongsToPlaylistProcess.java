package menu.features.addLocalSongsToPlaylist;

import menu.features.addLocalSongsToPlaylist.chain.HandlerCheckChoiceInLocalSong;
import menu.features.addLocalSongsToPlaylist.chain.HandlerSetSelectLocalSong;
import menu.template.Command;
import menu.template.CommandInput;
import menu.template.Navigator;
import menu.features.addLocalSongsToPlaylist.chain.HandlerAddSongsToSelectPlaylist;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import menu.features.addToPlaylists.selectSongs.chain.HandlerValidChoiceFormatPlaylist;
import menu.features.removeMultiple.chain.HandlerNavigateBack;
import services.AllSongListManagement;

public class CommandAddLocalSongsToPlaylistProcess implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigatorBack;

    public CommandAddLocalSongsToPlaylistProcess(AllSongListManagement listManagement, Navigator navigatorBack) {
        this.listManagement = listManagement;
        this.navigatorBack = navigatorBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleSong handlerBack = new HandlerNavigateBack(null, navigatorBack);
        HandleChooseMultipleSong handlerAddToPlaylist = new HandlerAddSongsToSelectPlaylist(handlerBack);
        HandleChooseMultipleSong handlerSetSelectedSong = new HandlerSetSelectLocalSong(handlerAddToPlaylist);
        HandleChooseMultipleSong handlerCheckChoice = new HandlerCheckChoiceInLocalSong(handlerSetSelectedSong, navigatorBack);
        HandleChooseMultipleSong handleValidFormat = new HandlerValidChoiceFormatPlaylist(handlerCheckChoice);

        CommandInput inputChoice = new CommandInputMultipleInt("Type numbers with space in between: ");
        inputChoice.execute();
        SelectedItems selectedItems = new SelectedItems(inputChoice.getInput());

        handleValidFormat.handle(listManagement, selectedItems);
    }
}
