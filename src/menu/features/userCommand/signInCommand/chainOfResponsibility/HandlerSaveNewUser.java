package menu.features.userCommand.signInCommand.chainOfResponsibility;

import entity.CurrentUser;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;

public class HandlerSaveNewUser implements HandlerUser {
    private HandlerUser next;

    public HandlerSaveNewUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        CurrentUser.getInstance().setCurrentUser(requestUser.getUsername(), requestUser.getPassword());
        return true;
    }

    @Override
    public void handle(RequestUser requestUser) {
        if (!doHandle(requestUser)) {
            return;
        }
        if (next != null) {
            next.handle(requestUser);
        }
    }
}
