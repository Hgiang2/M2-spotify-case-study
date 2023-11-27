package menu.features.searchCommand.searchNewMusic;

import menu.features.searchCommand.searchNewMusic.chain.HandlerCheckRole;
import menu.features.Command;
import menu.features.CommandInput;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.searchCommand.searchNewMusic.chain.HandlerCheckArtistName;
import menu.features.searchCommand.searchNewMusic.chain.HandlerCheckSearchResult;
import menu.features.searchCommand.searchNewMusic.chain.HandlerCheckSongName;
import menu.features.searchCommand.searchNewMusic.chain.HandlerNavigatePremiumDisplaySearchResult;
import menu.features.searchCommand.searchNewMusic.chain.HandlerSetSearchResult;

public class CommandSearchNewMusicProcess implements Command {
    @Override
    public void execute() {
        HandlerSearchItem handlerNavigateSearchResult = new HandlerNavigatePremiumDisplaySearchResult(null);
        HandlerSearchItem handlerCheckRole = new HandlerCheckRole(handlerNavigateSearchResult);
        HandlerSearchItem handlerCheckResult = new HandlerCheckSearchResult(handlerCheckRole);
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
