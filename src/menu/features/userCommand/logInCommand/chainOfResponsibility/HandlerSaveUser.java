package menu.features.userCommand.logInCommand.chainOfResponsibility;

import entity.CurrentUser;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;

public class HandlerSaveUser implements HandlerUser {
    private HandlerUser next;

    public HandlerSaveUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
//        CurrentUser.getInstance().setUsername(requestUser.getUsername());
        CurrentUser.getInstance().setCurrentUser(requestUser.getUsername(), requestUser.getPassword());
        System.out.println();
        System.out.println("Logging in....");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
