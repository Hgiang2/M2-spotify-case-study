package menu.service.addToFavoritesCommand.chain;

import constant.Constants;
import menu.service.addToFavoritesCommand.HandlerMultipleChoice;
import services.AllSongListManagement;
import services.validator.ValidateMultipleChoiceFormat;

public class HandlerValidateChoiceFormat implements HandlerMultipleChoice {
    private HandlerMultipleChoice next;

    public HandlerValidateChoiceFormat(HandlerMultipleChoice next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(AllSongListManagement listManagement, String choice) {
        return new ValidateMultipleChoiceFormat(choice).isCheck();
    }

    @Override
    public void handle(AllSongListManagement listManagement, String choice) {
        boolean isHandle = doHandle(listManagement, choice);
        while (!isHandle) {
            System.out.print("Wrong format! Please enter again: ");
            choice = Constants.SCANNER.next();
            isHandle = this.doHandle(listManagement, choice);
        }
        if (next != null) {
            next.handle(listManagement, choice);
        }
    }
}
