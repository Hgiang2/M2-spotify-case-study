package menu.service.userCommand.signInCommand.chainOfResponsibility;

import entity.User;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;
import menu.service.userCommand.ValidUsersList;
import services.observer.Subject;

public class HandlerCreateNewUser extends Subject implements HandlerUser {
    private HandlerUser next;

    public HandlerCreateNewUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        ValidUsersList.getInstance().getValidUsers().add(new User(requestUser.getUsername(), requestUser.getPassword()));
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
