package menu.features.checkPlan;

import constant.Constants;
import entity.CurrentUser;

public class HandlerPlanCheckUser implements HandlerPlan {
    private HandlerPlan next;

    public HandlerPlanCheckUser(HandlerPlan next) {
        this.next = next;
    }

    @Override
    public boolean doHandle() {
        return CurrentUser.getInstance().getCurrentUser().getRole().equals(Constants.NORMAL_USER);
    }

    @Override
    public void handle() {
        if (!doHandle()) {
            next = new HandlerPlanNavigateCheckPlanPremium(null);
        }
        if (next != null) next.handle();
    }
}
