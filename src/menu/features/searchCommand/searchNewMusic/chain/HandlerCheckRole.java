package menu.features.searchCommand.searchNewMusic.chain;

import constant.Constants;
import menu.features.searchCommand.HandlerSearchItem;
import menu.features.searchCommand.SearchNewMusicResult;
import menu.features.userCommand.CurrentUser;

public class HandlerCheckRole implements HandlerSearchItem {
    private HandlerSearchItem next;

    public HandlerCheckRole(HandlerSearchItem next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(SearchNewMusicResult searchResult) {
        return CurrentUser.getInstance().getRole().equals(Constants.PREMIUM_USER);
    }

    @Override
    public void handle(SearchNewMusicResult searchResult) {
        if (!doHandle(searchResult)) {
            next = new HandlerDisplayOtherSearchResult(null);
//            return;
        }
        if (next != null) {
            next.handle(searchResult);
        }
    }
}
