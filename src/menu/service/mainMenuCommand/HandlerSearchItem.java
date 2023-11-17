package menu.service.mainMenuCommand;

import menu.service.mainMenuCommand.searchNewMusic.SearchNewMusicResult;

public interface HandlerSearchItem {
    boolean doHandle(SearchNewMusicResult searchResult);
    void handle(SearchNewMusicResult searchResult);
}
