package menu.features.addToFavorites.chainAddMultiple;

import menu.template.CommandInput;
import menu.features.addToFavorites.addMultiple.CommandInputMultipleInt;
import menu.features.addToFavorites.addMultiple.HandleAddToFavorites;
import services.AllSongListManagement;
import services.validator.ValidateMultipleChoiceFormat;

public class HandlerValidateChoiceFormat implements HandleAddToFavorites {
    private HandleAddToFavorites next;

    public HandlerValidateChoiceFormat(HandleAddToFavorites next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        return new ValidateMultipleChoiceFormat(choice).isCheck();
    }

    @Override
    public void handle(AllSongListManagement listManagement, String choice) {
        boolean isHandle = this.doHandle(listManagement, choice);
        while (!isHandle) {
            CommandInput choiceInput = new CommandInputMultipleInt("Wrong format! Please enter again: ");
            choiceInput.execute();
            choice = choiceInput.getInput();
            isHandle = this.doHandle(listManagement, choice);
        }
        if (next != null) {
            next.handle(listManagement, choice);
        }
    }
}
