package menu.features.searchCommand.searchLocalLibrary;

import menu.template.Command;
import menu.template.CommandInput;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.searchCommand.searchLocalLibrary.chain.HandlerCheckArtistNameLocal;
import menu.features.searchCommand.searchLocalLibrary.chain.HandlerCheckPlaylistName;
import menu.features.searchCommand.searchLocalLibrary.chain.HandlerCheckSearchResultLocal;
import menu.features.searchCommand.searchLocalLibrary.chain.HandlerCheckSongNameLocal;
import menu.features.searchCommand.searchLocalLibrary.chain.HandlerDisplaySearchResultLocal;
import menu.features.searchCommand.searchNewMusic.CommandInputSearchItem;
import menu.features.searchCommand.searchNewMusic.chain.HandlerSetSearchResult;

public class CommandSearchLocalProcess implements Command {
    @Override
    public void execute() {
        HandlerSearchItem handlerNavigateSearchResult = new HandlerDisplaySearchResultLocal(null);
        HandlerSearchItem handlerCheckResult = new HandlerCheckSearchResultLocal(handlerNavigateSearchResult);
        HandlerSearchItem handlerSetResult = new HandlerSetSearchResult(handlerCheckResult);
        HandlerSearchItem handlerCheckSongName = new HandlerCheckSongNameLocal(handlerSetResult);
        HandlerSearchItem handlerCheckArtistName = new HandlerCheckArtistNameLocal(handlerCheckSongName);
        HandlerSearchItem handlerCheckPlaylistName = new HandlerCheckPlaylistName(handlerCheckArtistName);
        CommandInput inputSearchItem = new CommandInputSearchItem("Search for titles, artists or playlists: ");
        inputSearchItem.execute();
        String searchItem = inputSearchItem.getInput();

        SearchNewMusicResult searchResult = new SearchNewMusicResult(searchItem);
        handlerCheckPlaylistName.handle(searchResult);
    }
}
