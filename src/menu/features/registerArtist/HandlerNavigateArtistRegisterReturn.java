package menu.features.registerArtist;

import menu.template.NavigateArtistRegisterReturn;
import menu.template.Navigator;

public class HandlerNavigateArtistRegisterReturn implements HandlerString {
    private HandlerString next;

    public HandlerNavigateArtistRegisterReturn(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        System.out.println();
        System.out.println("Email collected!...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Navigator navigator = new NavigateArtistRegisterReturn();
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
