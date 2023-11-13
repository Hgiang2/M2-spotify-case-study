package menu.service.mainMenuCommand;

import menu.service.mainMenuCommand.searchNewMusic.SearchResult;

public interface HandlerSearchItem {
    boolean doHandle(SearchResult searchResult);
    void handle(SearchResult searchResult);
}
