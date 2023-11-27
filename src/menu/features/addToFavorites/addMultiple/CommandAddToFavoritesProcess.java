package menu.features.addToFavorites.addMultiple;

import menu.features.Command;
import menu.features.CommandInput;
import menu.template.Navigator;
import menu.features.addToFavorites.chainAddMultiple.HandlerAddMultipleToFavorites;
import menu.features.addToFavorites.chainAddMultiple.HandlerNavigateBack;
import menu.features.addToFavorites.chainAddMultiple.HandlerUpdate;
import menu.features.addToFavorites.chainAddMultiple.HandlerValidateChoiceFormat;
import services.AllSongListManagement;

public class CommandAddToFavoritesProcess implements Command {
    private AllSongListManagement listManagement;
    private Navigator navigateBack;

    public CommandAddToFavoritesProcess(AllSongListManagement listManagement, Navigator navigateBack) {
        this.listManagement = listManagement;
        this.navigateBack = navigateBack;
    }

    @Override
    public void execute() {
        HandleAddToFavorites handlerNavigateBack = new HandlerNavigateBack(null, navigateBack);
        HandleAddToFavorites handlerUpdate = new HandlerUpdate(handlerNavigateBack);
        HandleAddToFavorites handlerAddMultipleToFavorites = new HandlerAddMultipleToFavorites(handlerUpdate, navigateBack);
        HandleAddToFavorites handlerValidateChoiceFormat = new HandlerValidateChoiceFormat(handlerAddMultipleToFavorites);
        CommandInput choiceInput = new CommandInputMultipleInt("Type numbers with space in between: ");
        choiceInput.execute();
        String choice = choiceInput.getInput();

        handlerValidateChoiceFormat.handle(listManagement, choice);
    }
}
