package menu.service.userCommand.logInCommand.chainOfResponsibility;

import menu.service.userCommand.CurrentUser;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;

public class HandlerSaveUser implements HandlerUser {
    private HandlerUser next;

    public HandlerSaveUser(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
//        CurrentUser.getInstance().setUsername(requestUser.getUsername());
        CurrentUser.getInstance().setCurrentUser(requestUser.getUsername(), requestUser.getPassword());
        return true;
    }

    @Override
    public void handle(RequestUser requestUser) {
        if(!doHandle(requestUser)){
            return;
        }
        if(next != null) {
            next.handle(requestUser);
        }
    }
}
