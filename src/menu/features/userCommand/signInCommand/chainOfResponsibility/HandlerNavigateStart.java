package menu.features.userCommand.signInCommand.chainOfResponsibility;

import menu.template.NavigateMenuStart;
import menu.template.Navigator;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;

public class HandlerNavigateStart implements HandlerUser {
    private HandlerUser next;

    public HandlerNavigateStart(HandlerUser next) {
        this.next = next;
    }
    @Override
    public boolean doHandle(RequestUser requestUser) {
        Navigator navigator = new NavigateMenuStart();
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
