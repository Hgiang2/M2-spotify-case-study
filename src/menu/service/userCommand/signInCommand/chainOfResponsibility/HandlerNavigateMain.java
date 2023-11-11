package menu.service.userCommand.signInCommand.chainOfResponsibility;

import menu.menuCommand.NavigateMenuMain;
import menu.menuCommand.Navigator;
import menu.service.userCommand.HandlerUser;
import menu.service.userCommand.RequestUser;

public class HandlerNavigateMain implements HandlerUser {
    private HandlerUser next;

    public HandlerNavigateMain(HandlerUser next) {
        this.next = next;
    }
    @Override
    public boolean doHandle(RequestUser requestUser) {
        Navigator navigator = new NavigateMenuMain();
        navigator.navigate();
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
