package menu.features.searchCommand;

public interface HandlerSearchItem {
    boolean doHandle(SearchNewMusicResult searchResult);
    void handle(SearchNewMusicResult searchResult);
}
