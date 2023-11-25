package menu.features.addToPlaylists.selectPlaylists.chain;

import menu.template.CommandInput;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToPlaylists.selectPlaylists.HandleChooseMultipleItems;
import menu.features.addToPlaylists.selectSongs.SelectedItems;
import services.validator.ValidateMultipleChoiceFormat;

public class HandlerValidChoiceFormat implements HandleChooseMultipleItems {
    private HandleChooseMultipleItems next;

    public HandlerValidChoiceFormat(HandleChooseMultipleItems next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SelectedItems selectedItems) {
        return new ValidateMultipleChoiceFormat(selectedItems.getChoice()).isCheck();
    }

    @Override
    public void handle(SelectedItems selectedItems) {
        boolean isHandle = this.doHandle(selectedItems);
        while (!isHandle) {
            CommandInput choiceInput = new CommandInputMultipleInt("Wrong format! Please enter again: ");
            choiceInput.execute();
            selectedItems.setChoice(choiceInput.getInput());
            isHandle = this.doHandle(selectedItems);
        }
        if (next != null) {
            next.handle(selectedItems);
        }
    }
}
