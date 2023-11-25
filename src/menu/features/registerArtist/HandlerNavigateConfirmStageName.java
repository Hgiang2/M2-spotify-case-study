package menu.features.registerArtist;

import menu.template.NavigateConfirmStageName;
import menu.template.Navigator;

public class HandlerNavigateConfirmStageName implements HandlerString {
    private HandlerString next;

    public HandlerNavigateConfirmStageName(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        Navigator navigator = new NavigateConfirmStageName(stageName);
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
