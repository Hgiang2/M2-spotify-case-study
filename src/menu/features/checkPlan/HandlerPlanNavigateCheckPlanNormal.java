package menu.features.checkPlan;

import menu.template.NavigateCheckPlanNormal;
import menu.template.Navigator;

public class HandlerPlanNavigateCheckPlanNormal implements HandlerPlan {
    private HandlerPlan next;

    public HandlerPlanNavigateCheckPlanNormal(HandlerPlan next) {
        this.next = next;
    }

    @Override
    public boolean doHandle() {
        Navigator navigator = new NavigateCheckPlanNormal();
        navigator.navigate();
        return true;
    }

    @Override
    public void handle() {
        if (!doHandle()) return;
        if (next != null) next.handle();
    }
}
