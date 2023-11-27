package menu.features.checkPlan;

import menu.features.Command;

public class CommandCheckPlan implements Command {
    @Override
    public void execute() {
        HandlerPlan handlerPlanNavigateCheckPlanNormal = new HandlerPlanNavigateCheckPlanNormal(null);
        HandlerPlan handlerPlanCheckUser = new HandlerPlanCheckUser(handlerPlanNavigateCheckPlanNormal);
        handlerPlanCheckUser.handle();
    }
}
