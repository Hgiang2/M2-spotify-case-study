package menu.features.registerArtist;

import entity.Email;

public class HandlerSetEmail implements HandlerString {
    private HandlerString next;

    public HandlerSetEmail(HandlerString next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(String stageName) {
        Email.getInstance().setEmail(stageName);
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
