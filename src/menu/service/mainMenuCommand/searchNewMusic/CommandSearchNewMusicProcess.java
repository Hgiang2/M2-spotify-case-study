package menu.service.mainMenuCommand.searchNewMusic;

import menu.menuCommand.Command;
import menu.menuCommand.CommandInput;
import menu.service.mainMenuCommand.HandlerSearchItem;
import menu.service.mainMenuCommand.searchNewMusic.chain.HandlerCheckArtistName;
import menu.service.mainMenuCommand.searchNewMusic.chain.HandlerCheckSearchResult;
import menu.service.mainMenuCommand.searchNewMusic.chain.HandlerCheckSongName;
import menu.service.mainMenuCommand.searchNewMusic.chain.HandlerNavigateDisplaySearchResult;
import menu.service.mainMenuCommand.searchNewMusic.chain.HandlerSetSearchResult;

public class CommandSearchNewMusicProcess implements Command {
    @Override
    public void execute() {
        HandlerSearchItem handlerNavigateSearchResult = new HandlerNavigateDisplaySearchResult(null);
        HandlerSearchItem handlerCheckResult = new HandlerCheckSearchResult(handlerNavigateSearchResult);
        HandlerSearchItem handlerSetResult = new HandlerSetSearchResult(handlerCheckResult);
        HandlerSearchItem handlerCheckSongName = new HandlerCheckSongName(handlerSetResult);
        HandlerSearchItem handlerCheckArtistName = new HandlerCheckArtistName(handlerCheckSongName);
        CommandInput inputSearchItem = new CommandInputSearchItem("Search for titles or artists: ");
        inputSearchItem.execute();
        String searchItem = inputSearchItem.getInput();

        SearchNewMusicResult searchResult = new SearchNewMusicResult(searchItem);
        handlerCheckArtistName.handle(searchResult);
    }
}
