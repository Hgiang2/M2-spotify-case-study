package menu.service.addToFavoritesCommand;

import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;
import menu.menuCommand.Navigator;
import menu.service.addToFavoritesCommand.chain.HandlerAddMultipleToFavorites;
import menu.service.addToFavoritesCommand.chain.HandlerNavigateBack;
import menu.service.addToFavoritesCommand.chain.HandlerValidateChoiceFormat;
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
        HandlerMultipleChoice handlerNavigateBack = new HandlerNavigateBack(null, navigateBack);
        HandlerMultipleChoice handlerAddMultipleToFavorites = new HandlerAddMultipleToFavorites(handlerNavigateBack);
        HandlerMultipleChoice handlerValidateChoiceFormat = new HandlerValidateChoiceFormat(handlerAddMultipleToFavorites);
        CommandInput choiceInput = new CommandInputMultipleInt();
        choiceInput.execute();
        String choice = choiceInput.getInput();

        handlerValidateChoiceFormat.handle(listManagement, choice);
    }
}
