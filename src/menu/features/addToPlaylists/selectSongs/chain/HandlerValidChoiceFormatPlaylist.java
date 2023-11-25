package menu.features.addToPlaylists.selectSongs.chain;

import menu.template.CommandInput;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectSongs.HandleChooseMultipleSong;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.AllSongListManagement;
import services.validator.ValidateMultipleChoiceFormat;

public class HandlerValidChoiceFormatPlaylist implements HandleChooseMultipleSong {
    private HandleChooseMultipleSong next;

    public HandlerValidChoiceFormatPlaylist(HandleChooseMultipleSong next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        return new ValidateMultipleChoiceFormat(selectedItems.getChoice()).isCheck();
    }

    @Override
    public void handle(AllSongListManagement listManagement, SelectedItems selectedItems) {
        boolean isHandle = this.doHandle(listManagement, selectedItems);
        while (!isHandle) {
            CommandInput choiceInput = new CommandInputMultipleInt("Wrong format! Please enter again: ");
            choiceInput.execute();
            selectedItems.setChoice(choiceInput.getInput());
            isHandle = this.doHandle(listManagement, selectedItems);
        }
        if (next != null) {
            next.handle(listManagement, selectedItems);
        }
    }
}
