package menu.features.userCommand.signInCommand.chainOfResponsibility;

import constant.Constants;
import entity.CurrentUser;
import menu.features.userCommand.HandlerUser;
import menu.features.userCommand.RequestUser;
import menu.template.NavigateMenuAdmin;
import menu.template.NavigateMenuArtist;
import menu.template.NavigateMenuMain;
import menu.template.NavigateMenuNormalMain;
import menu.template.Navigator;

public class HandlerNavigateMain implements HandlerUser {
    private HandlerUser next;

    public HandlerNavigateMain(HandlerUser next) {
        this.next = next;
    }

    @Override
    public boolean doHandle(RequestUser requestUser) {
        String role = CurrentUser.getInstance().getCurrentUser().getRole();
        Navigator navigator;
        if (role.equals(Constants.NORMAL_USER)) {
            navigator = new NavigateMenuNormalMain();
        } else if (role.equals(Constants.PREMIUM_USER)) {
            navigator = new NavigateMenuMain();
        } else if (role.equals(Constants.ARTIST)) {
            navigator = new NavigateMenuArtist(requestUser.getUsername());
        } else {
            navigator = new NavigateMenuAdmin();
        }
        navigator.navigate();
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
