package menu.features.gmail;

import entity.Email;
import menu.features.registerArtist.HandlerString;
import menu.template.NavigateGmail;
import menu.template.NavigateGmailMenu;
import menu.template.Navigator;

public class HandlerNavigateGmail implements HandlerString {
    private HandlerString next;

    public HandlerNavigateGmail(HandlerString next) {
        this.next = next;
    }
    @Override
    public boolean doHandle(String stageName) {
        Navigator navigator = new NavigateGmailMenu();
        navigator.navigate();
        return true;
    }

    @Override
    public void handle(String stageName) {
        if (!doHandle(stageName)) {
            return;
        }
        if (next != null) {
            next.handle(stageName);
        }
    }
}
