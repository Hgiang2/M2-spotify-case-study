package menu.features.checkPlan;

import menu.template.Navigator;

public class HandlerPlanNavigateCheckPlanPremium implements HandlerPlan {
    private HandlerPlan next;

    public HandlerPlanNavigateCheckPlanPremium(HandlerPlan next) {
        this.next = next;
    }

    @Override
    public boolean doHandle() {
        Navigator navigator = new NavigateCheckPlanPremium();
        navigator.navigate();
        return true;
    }

    @Override
    public void handle() {
        if (!doHandle()) return;
        if (next != null) next.handle();
    }
}
