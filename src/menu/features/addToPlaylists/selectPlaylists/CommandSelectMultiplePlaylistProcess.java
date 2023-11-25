package menu.features.addToPlaylists.selectPlaylists;

import menu.template.Command;
import menu.template.CommandInput;
import menu.template.Navigator;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectPlaylists.chain.HandlerAddSongsToMultiplePlaylists;
import menu.features.addToPlaylists.selectPlaylists.chain.HandlerCheckChoice;
import menu.features.addToPlaylists.selectPlaylists.chain.HandlerNavigateBack;
import menu.features.addToPlaylists.selectPlaylists.chain.HandlerSetPlaylist;
import menu.features.addToPlaylists.selectPlaylists.chain.HandlerValidChoiceFormat;
import menu.features.addToPlaylists.selectSongs.SelectedItems;

import java.util.ArrayList;

public class CommandSelectMultiplePlaylistProcess implements Command {
    private SelectedItems selectedItems;
    private Navigator navigateBack;

    public CommandSelectMultiplePlaylistProcess(SelectedItems selectedItems, Navigator navigateBack) {
        this.selectedItems = selectedItems;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleChooseMultipleItems handlerNavigateBack = new HandlerNavigateBack(null, navigateBack);
        HandleChooseMultipleItems handlerAddSongsToPlaylists = new HandlerAddSongsToMultiplePlaylists(handlerNavigateBack);
        HandleChooseMultipleItems handlerSetSelectedPlaylists = new HandlerSetPlaylist(handlerAddSongsToPlaylists);
        HandleChooseMultipleItems handlerCheckChoice = new HandlerCheckChoice(handlerSetSelectedPlaylists, navigateBack);
        HandleChooseMultipleItems handlerValidFormat = new HandlerValidChoiceFormat(handlerCheckChoice);

        CommandInput input = new CommandInputMultipleInt("Type numbers with space in between: ");
        input.execute();
        selectedItems.setChoice(input.getInput());
        selectedItems.setChoiceList(new ArrayList<>());
        handlerValidFormat.handle(selectedItems);
    }
}
