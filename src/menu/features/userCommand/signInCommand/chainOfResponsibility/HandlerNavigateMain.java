package menu.features.userCommand.signInCommand.chainOfResponsibility;

import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.template.NavigateMenuNormalMain;
import menu.template.Navigator;

public class HandlerNavigateMain implements HandlerUser {
    private HandlerUser next;

    public HandlerNavigateMain(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        Navigator navigator = new NavigateMenuNormalMain();
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
